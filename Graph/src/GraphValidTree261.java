import java.util.Arrays;
import java.util.*;

public class GraphValidTree261 {
	//one solution find cycle through dfs and bfs complexity o(V+E)
	private static int[] parent;
    private static int[] size;
    //o(E)
    public static boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        size = new int[n];
        Arrays.fill(size, 1);
        
        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return false;
            }
        }
        return edges.length == n - 1;
    }
    
    private static boolean union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        
        if (p1 == p2) {
            return false;
        }
        if (size[p1] < size[p2]) {
            parent[p1] = p2;
            size[p2]++;
        } else {
            parent[p2] = p1;
            size[p1]++;
        }
        return true;
    }
    
    private static int find(int v) {
        while (v != parent[v]) {
            parent[v] = find(parent[parent[v]]);
            v = parent[v];
        }
        return v;
    }
//sol2 DFS
    public boolean validTree1(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }
        if (n != edges.length + 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }
        return visited.size() == n;
    }
    
    private boolean hasCycle(int node, int parent, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent && visited.contains(neighbor)) {
                return true;
            }
            if (!visited.contains(neighbor) && hasCycle(neighbor, node, graph, visited)) {
                return true;
            }
        }
        return false;
    }
//sol3
    public static boolean validTree2(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            List<Integer> neighbors1 = graph.getOrDefault(edge[0], new ArrayList<>());
            List<Integer> neighbors2 = graph.getOrDefault(edge[1], new ArrayList<>());
            neighbors1.add(edge[1]);
            neighbors2.add(edge[0]);
            graph.put(edge[0], neighbors1);
            graph.put(edge[1], neighbors2);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(edges[0][0]);
        visited.add(edges[0][0]);
        int nodes = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            nodes++;
            
            for (int neighbor : graph.get(node)) {
                if (queue.contains(neighbor)) {
                    return false;
                }
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;
    }
	public static void main(String[] args) {
		
			int n = 5;
			int[][] edges = {{0, 1}, {1, 2}, {3, 4},{0,3}};
			System.out.println( validTree2(n,edges));

	}

}
