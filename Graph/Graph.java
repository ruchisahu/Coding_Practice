package robertSedwick;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    private int E;
    Bag<Integer>[] adj;
    
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
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
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w); 
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        }
    }

    public Graph(Graph G) {
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

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }


  
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

 
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
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
    //degree of 1
    public static int degree(Graph G, int v ) {
    	int degree=0;
    	for(int w:G.adj(v))degree++;
    	
		return degree;
    	
    }
    //maximum degree
    public static int maxDegreeGraph(Graph G) {
    	int max=0;
    	for(int v=0;v<G.V();v++) {
    		 StdOut.println("degree of "+v+" = "+degree(G,v));
    		if(degree(G,v)>max) {
    			
    			max=degree(G,v);
    		}
    	}
    	return max;
    }
 //no of self loop
    public static int  numberOfSelfloop(Graph G) {
    	int count=0;
    	for(int v=0;v<G.V();v++) {
    		for(int w:G.adj(v)){
    			if(w==v) {
    				 StdOut.println("Self loop="+w);
    			
    				count++;
    			}
    		}
    	}
    	
    	return count/2;
    }
   //4.1.4 
    public static boolean hasEdge( Graph G,int v, int w){
        Iterator<Integer> it = G.adj[v].iterator();
        while(it.hasNext()){
            if(it.next() == w){
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyGex2.txt");
        Graph G = new Graph(in);
        StdOut.println(G);
        
        StdOut.println("Degree of 2="+degree(G, 2 ));
        
        StdOut.println("Max Degree ="+maxDegreeGraph(G));
        
        StdOut.println("Self loop ="+numberOfSelfloop(G));
        
        StdOut.println("Edge between v-w ="+hasEdge(G,8,9));
        
        StdOut.println("Edge between v-w ="+hasEdge(G,0,5));
    }

}