import java.util.ArrayList;
import java.util.List;

public class ConnectedComponent {
	
	public static int connectedComponent(int[][]edges,int n){
		int count=0;
		ArrayList<Integer>[] adj=new ArrayList[n];
		
		 for (int i = 0; i < n; i++) { 
	            adj[i] = new ArrayList<Integer>(); 
	        } 
		for(int i=0;i<edges.length;i++) {
			adj[edges[i][0]].add(edges[i][1]);
			adj[edges[i][1]].add(edges[i][0]);
		}
		boolean[]visited=new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				++count;
				dfs(i,adj,visited);
			}
		}
		return count;
		
	}

	private static void dfs(int v, ArrayList<Integer>[] adj, boolean[] visited) {
		visited[v]=true;
		for(int next=0;next<adj[v].size();next++) {
			int w=adj[v].get(next);
			if(!visited[w]) {
				dfs(w, adj,visited);
			}
		}
		
	}

	public static void main(String[] args) {
		 int n = 5;
		 int[][]edges = {{0, 1}, {1, 2}, {3, 4}};
		 System.out.println(connectedComponent(edges,n)); //return 2.
		 
		int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
		System.out.println(connectedComponent(edges1,n)); //return 1

	}

}
