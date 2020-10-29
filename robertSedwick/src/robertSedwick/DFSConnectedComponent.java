package robertSedwick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class DFSConnectedComponent {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public DFSConnectedComponent(Graph G ){
		marked=new boolean[(G.V())];
		id=new int[G.V()];
		for(int s=0;s<G.V();s++) {
			if(!marked[s]) {
				dfs(G,s);
				count++;  //count connected component
			}
		}
	
	}

	private void dfs(Graph G, int v) {
		marked[v]=true;		
		id[v]=count;
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				dfs(G,w);
				
				}
			
		}
	}
	public boolean marked(int w) {
		return marked[w];
	}
	
	public int count() {
		return count;
	}
	public int id(int v) {
		return id[v];
	}
	public boolean connected(int v,int w) {
		return id[v]==id[w];
	}
	
	 public static void main(String[] args) {
		 In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyCG.txt");
	        Graph G = new Graph(in);
	        DFSConnectedComponent cc = new DFSConnectedComponent(G);

	        // number of connected components
	        int m = cc.count();
	        StdOut.println(m + " components");

	        // compute list of vertices in each connected component
	        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
	        for (int i = 0; i < m; i++) {
	            components[i] = new Queue<Integer>();
	        }
	        for (int v = 0; v < G.V(); v++) {
	            components[cc.id(v)].enqueue(v);
	        }

	        // print results
	        for (int i = 0; i < m; i++) {
	            for (int v : components[i]) {
	                StdOut.print(v + " ");
	            }
	            StdOut.println();
	        }
	    }
	}
