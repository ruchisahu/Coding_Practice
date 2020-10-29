

	import java.util.*;



	public class ArticulationPoint1 {
		int time=0;
	    ArrayList<Integer> articulationResult = new ArrayList<>();

	    static class Graph{
	        int vertices;
	        LinkedList<Integer> adjList [];

	        public Graph(int vertices){
	            this.vertices = vertices;
	            adjList = new LinkedList[vertices];
	            for (int i = 0; i <vertices ; i++) {
	                adjList[i] = new LinkedList<>();

	            }
	        }
	        public void addEdge(int source, int destination){
            //forward edge
              adjList[source].addFirst(destination);
	            //backward edge in undirected graph
	            adjList[destination].addFirst(source);
	        }
	    }
	    
 	    public void findArticulationPoints(Graph graph){
	        int vertices = graph.vertices;
	        Map<Integer, Integer> visitTime = new HashMap<>();
	        Map<Integer, Integer> lowTime = new HashMap<>();
	        Map<Integer, Integer> parent = new HashMap<>();

	        //created visited array
	        boolean[] visited = new boolean[vertices];
	        //this loop will handle disconnected graphs as well
	        for (int i = 0; i <vertices ; i++) {
	            if(!visited[i])
	                DFS(graph, i, visitTime, lowTime, visited, parent);
	        }

	        if(articulationResult.size()>0) {
	            System.out.println("Articulation Points are: " +  Arrays.toString(articulationResult.toArray()));

	        }else{
                System.out.println("No Articulation Points in the given graph");
	        }
	    }

	    public void DFS(Graph graph, int currentVertex, Map<Integer, Integer> discoveryTime, Map<Integer, Integer> lowTime, boolean[] visited, Map<Integer, Integer> parent){

	        LinkedList<Integer> adjList [] = graph.adjList;
	        int childCount = 0;
	        boolean canArticulationPoint = false;
	        visited[currentVertex] = true;
	        discoveryTime.put(currentVertex, time);
	        lowTime.put(currentVertex, time);
	        time++;
	        for (int i = 0; i <adjList[currentVertex].size() ; i++) {

	            int adjacentVertex = adjList[currentVertex].get(i);
	            if(!visited[adjacentVertex]){
	                //make current vertex as parent of adjacent vertex
	                // and increase the child count for current vertex
	                parent.put(adjacentVertex, currentVertex);
	                childCount++;

	                //make recursive call for the adjacent vertex
	                DFS(graph, adjacentVertex, discoveryTime, lowTime, visited, parent);

	                //check for articulation point
	                if(discoveryTime.get(currentVertex)<=lowTime.get(adjacentVertex)){
	                    canArticulationPoint = true;

	                } else{

	                    //check the low point is adjacent vertex is less than current vertex,
	                    //if yes then update the current vertex low point

	                    int currLowTime = lowTime.get(currentVertex);
	                    lowTime.put(currentVertex, Math.min(currLowTime, lowTime.get(adjacentVertex)));

	                }

	            }else{

	                //if here means the vertex was visited earlier,

	                //certainly there is a back edge,

	                // update the low time of current vertex with visited time of adjacent vertex if needed

	                int currLowTime = lowTime.get(currentVertex);

	                lowTime.put(currentVertex, Math.min(currLowTime, discoveryTime.get(adjacentVertex)));

	            }

	        }

	        //after visiting all the adjacent vertices check if current vertex is articulation point

	        if((parent.get(currentVertex)==null && childCount>1)||(parent.get(currentVertex)!=null && canArticulationPoint)){

	            //current vertex is AP, add it to the list

	            articulationResult.add(currentVertex);

	        }

	    }



	    public static void main(String[] args) {

	        Graph graph = new Graph(7);

	        graph.addEdge(0, 1);

	        graph.addEdge(0, 2);

	        graph.addEdge(1, 3);

	        graph.addEdge(1, 4);

	        graph.addEdge(2, 5);

	        graph.addEdge(2, 6);

	        graph.addEdge(5, 6);



	        ArticulationPoint1 ap = new ArticulationPoint1();

	        ap.findArticulationPoints(graph);

	    }

	

}
