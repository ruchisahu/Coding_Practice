package robertSedwick;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class GraphNoParallelEdgesOrSelfLoops_4_1_5 {
	 private static final String NEWLINE = System.getProperty("line.separator");

	    private final int V;
	    private int E;
	    static Bag<Integer>[] adj;
	    
	    public GraphNoParallelEdgesOrSelfLoops_4_1_5(int V) {
	        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
	        this.V = V;
	        this.E = 0;
	        adj = (Bag<Integer>[]) new Bag[V];
	        for (int v = 0; v < V; v++) {
	            adj[v] = new Bag<Integer>();
	        }
	    }

	    public GraphNoParallelEdgesOrSelfLoops_4_1_5(In in) {
	        try {
	            this.V = in.readInt();
	            if (V < 0) throw new IllegalArgumentException("number of vertices in a Graph must be nonnegative");
	            adj = (Bag<Integer>[]) new Bag[V];
	            for (int v = 0; v < V; v++) {
	                adj[v] = new Bag<Integer>();
	            }
	            int E = in.readInt();
	            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be nonnegative");
	            for (int i = 0; i < E; i++) {
	                int v = in.readInt();
	                int w = in.readInt();
	                addEdge(v, w); 
	            }
	        }
	        catch (NoSuchElementException e) {
	            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
	        }
	    }

	    public GraphNoParallelEdgesOrSelfLoops_4_1_5(GraphNoParallelEdgesOrSelfLoops_4_1_5 G) {
	        this(G.V());
	        this.E = G.E();
	        for (int v = 0; v < G.V(); v++) {
	            // reverse so that adjacency list is in same order as original
	            Stack<Integer> reverse = new Stack<Integer>();
	            for (int w : G.adj[v]) {
	                reverse.push(w);
	            }
	            for (int w : reverse) {
	                adj[v].add(w);
	            }
	        }
	    }


	    public int V() {
	        return V;
	    }

	  
	    public int E() {
	        return E;
	    }

	

	    public void addEdge(int v, int w) {
	    	if (v == w) {
	    		System.out.println("problem: self loop");
                return;
	    	}
	    	else if(hasEdge(v, w)) {
	    		System.out.println("problem: parallel edges");
	    		return;
	    	}
	    	else
	    	{
	    		System.out.println("No problem");
	        E++;
	        adj[v].add(w);
	        adj[w].add(v);
	    	}
	    }


	  
	    public static Iterable<Integer> adj(int v) {
	     
	        return adj[v];
	    }

	 

	 
	    public String toString() {
	        StringBuilder s = new StringBuilder();
	        s.append(V + " vertices, " + E + " edges " + NEWLINE);
	        for (int v = 0; v < V; v++) {
	            s.append(v + ": ");
	            for (int w : adj[v]) {
	                s.append(w + " ");
	            }
	            s.append(NEWLINE);
	        }
	        return s.toString();
	    }

	   //4.1.5
	    public static boolean hasEdge(int v, int w){
	    	
	    	for(int neighbor: GraphNoParallelEdgesOrSelfLoops_4_1_5.adj(v)) {
                if (neighbor == w) {
                    return true;
                }
            }

            return false;
	    }

	public static void main(String[] args) {
		 In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\testSelfloopParallel.txt");
		 GraphNoParallelEdgesOrSelfLoops_4_1_5 G = new GraphNoParallelEdgesOrSelfLoops_4_1_5(in);
		

	}

}
