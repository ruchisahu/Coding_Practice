import java.util.*;

public class TarjanAlgo {
	//Creating as instance variables assuming its not a multi-threaded environment and to avoid passing objects over and over to the recursive function.
    private int time = 0;
    private List<List<Integer>> bridges;
    private Map<Integer, Boolean> visited;
    private Map<Integer, Integer> startTime;
    private Map<Integer, Integer> lowLinkValue;
    private Map<Integer, Set<Integer>> graphData;

    /**
     * Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
     * Space Complexity: O(V + E) where V is the number of vertices and E is the number of edges.
     */
    public List<List<Integer>> criticalConnections(int n, List<PairInt> connections) {
        if(connections == null || connections.size() == 0 || n == 0) return Collections.emptyList();

        bridges = new ArrayList<>();
        visited = new HashMap<>(n);
        startTime = new HashMap<>(n);
        lowLinkValue = new HashMap<>(n);
        graphData = buildGraph(connections);

        // Initially Marking all the vertices as unvisited
        graphData.keySet().forEach(vertex -> visited.put(vertex, false));

        // Finding bridges for all unvisited Vertices.
        graphData.keySet().forEach(vertex -> {
            if(!visited.get(vertex)) {
                findBridges(vertex, -1);
            }
        });
        return bridges;
    }

    private void findBridges(int vertex, int parent) {

        ++time;
        visited.put(vertex, true);
        startTime.put(vertex, time);
        lowLinkValue.put(vertex, time);

        //Finding the Bridges for all the unvisited Edges in the Vertex
        for(Integer edge : graphData.get(vertex)) {
            if(edge == parent) continue;

            if(!visited.get(edge)) {
                findBridges(edge, vertex);

                lowLinkValue.put(vertex, Math.min(lowLinkValue.get(vertex), lowLinkValue.get(edge)));

                //If the Start Time is lesser than the low link value of the edge then the edge is a bridge
                if(startTime.get(vertex) < lowLinkValue.get(edge)) {
                    bridges.add(Arrays.asList(vertex, edge));
                }
            } else {
                lowLinkValue.put(vertex, Math.min(lowLinkValue.get(vertex), startTime.get(edge)));
            }
        }
    }

    private Map<Integer, Set<Integer>> buildGraph(List<PairInt> connections) {
        Map<Integer, Set<Integer>> adjacencyList = new HashMap<>();

        //Building Graph - as this is a undirected graph adding connections both the sides if 0, 1 is given then i'm adding 0, 1 and 1, 0 to the graph
        for(PairInt connection : connections) {
            Set<Integer> firstSet = adjacencyList.getOrDefault(connection.first, new HashSet<>());
            firstSet.add(connection.second);
            adjacencyList.put(connection.first, firstSet);

            Set<Integer> secondSet = adjacencyList.getOrDefault(connection.second, new HashSet<>());
            secondSet.add(connection.first);
            adjacencyList.put(connection.second, secondSet);
        }
        return adjacencyList;
    }

    static class PairInt {
        private Integer first;
        private Integer second;

        PairInt(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        System.out.println("Critical Connections: " + new TarjanAlgo().criticalConnections(5, Arrays.asList(
                new PairInt(1, 2), new PairInt(1, 3), new PairInt(3, 4), new PairInt(1, 4), new PairInt(4, 5))));

        System.out.println("Critical Connections: " + new TarjanAlgo().criticalConnections(6, Arrays.asList(
                new PairInt(1, 2), new PairInt(1, 3), new PairInt(2, 3), new PairInt(2, 4), new PairInt(2, 5), new PairInt(4, 6), new PairInt(5, 6))));

        System.out.println("Critical Connections: " + new TarjanAlgo().criticalConnections(5, Arrays.asList(
                new PairInt(1, 2), new PairInt(1, 3), new PairInt(2, 3), new PairInt(3, 4), new PairInt(3, 6), new PairInt(4, 5), new PairInt(6, 7), new PairInt(6, 9), new PairInt(7, 8), new PairInt(8, 9))));

        System.out.println("Critical Connections: " + new TarjanAlgo().criticalConnections(4, Arrays.asList(
                new PairInt(0, 1), new PairInt(1, 2), new PairInt(2, 0), new PairInt(1, 3)
        )));
        System.out.println("Critical Connections: " + new TarjanAlgo().criticalConnections(5, Arrays.asList(
                new PairInt(0, 1), new PairInt(0, 3), new PairInt(0, 4), new PairInt(4, 2)
        )));
    }
}