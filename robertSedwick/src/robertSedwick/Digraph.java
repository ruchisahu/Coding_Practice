package robertSedwick;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Digraph {
	 private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;
	public int E;
	private List<Integer>[] adj;
	 private int[] indegree;        // indegree[v] = indegree of vertex v
	
	public Digraph(int V){
		this.V=V;
		this.E=E;
		indegree=new int[V];
		adj=(List<Integer>[])new List[V];
		for(int v=0;v<V;v++) {
			adj[v]=new ArrayList<Integer>();
		}
	}
	public Digraph(In in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("number of vertices in a Digraph must be nonnegative");
            indegree = new int[V];
            adj = (List<Integer>[]) new List[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<Integer>();
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Digraph constructor", e);
        }
    }
	public int V() {
		return V;
	}
	public int E() {
         return E;
    }
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		indegree[w]++;
		E++;
		
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	 public int outdegree(int v) {
	        return adj[v].size();
	 }
	 
	 public int indegree(int v) {
	        return indegree[v];
	 }
	 
	 public Digraph reverse() {
	        Digraph reverse = new Digraph(V);
	        for (int v = 0; v < V; v++) {
	            for (int w : adj(v)) {
	                reverse.addEdge(w, v);
	            }
	        }
	        return reverse;
	    }
	 public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(String.format("%d: ", v));
	            for (int w : adj[v]) {
	                s.append(String.format("%d ", w));
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }

	public static void main(String[] args) {
		 In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyDG.txt");
	        Digraph G = new Digraph(in);
	        StdOut.println(G);

	}

}
