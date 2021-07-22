import java.util.ArrayList;
import java.util.List;

// one solution dfs in robertswedwick/dfsconnectedcommonent

public class ConnectedComponents323 {
	//sol2: union find
	
	public static int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int r1 = find(roots, edges[i][0]);
            int r2 = find(roots, edges[i][1]);
            
            if (r1 != r2) {
                roots[r1] = r2;
                n--;
            }
        }
        
        return n;
    }
    
    private static int find(int[] roots, int key) {
        while (roots[key] != key) {
            key = roots[key];
        }
        
        return key;
    }
//sol2
    public int makeConnected(int n, int[][] connections) {
		if (connections.length < n - 1)
			return -1;

		// build graph
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] con : connections) {
			graph[con[0]].add(con[1]);
			graph[con[1]].add(con[0]);
		}
		boolean[] visited = new boolean[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(graph, i, visited);
				count++;
			}
		}
		return count - 1;
	}

	private void dfs(List<Integer>[] graph, int start, boolean[] visited) {
		List<Integer> neighbors = graph[start];
		for (int neighbor : neighbors) {
			if (!visited[neighbor]) {
				visited[neighbor] = true;
				dfs(graph, neighbor, visited);
			}
		}
		}

	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(countComponents(n, edges));

	}

}
