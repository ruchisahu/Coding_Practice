package robertSedwick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

// finding a directed cycle
public class DirectedCycle {
	    private boolean[] marked;        // marked[v] = has vertex v been marked?
	    private int[] edgeTo;            // edgeTo[v] = previous vertex on path to v
	    private boolean[] onStack;       // onStack[v] = is vertex on the stack?
	    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)
	
	public DirectedCycle(Digraph G) {
		onStack=new boolean[G.V()];
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		for(int v=0;v<G.V();v++) {
			if(!marked[v] && cycle ==null) {
				dfs(G,v);
			}
		}
	}
	
	 private void dfs(Digraph G, int v) {
		 marked[v]=true;
		 onStack[v]=true;
		 for(int w:G.adj(v)) {
			 if(cycle !=null) return;
	
			 else if(!marked[w]) {
				 edgeTo[w]=v;
				 dfs(G,w);
			 }
			 // trace back directed cycle
	            else if (onStack[w]) {
	                cycle = new Stack<Integer>();
	                for (int x = v; x != w; x = edgeTo[x]) {
	                    cycle.push(x);
	                }
	                cycle.push(w);
	                cycle.push(v);
	               
	            }
	        }
	        onStack[v] = false;
			 
		 }
	 
	 public boolean hasCycle() {
	        return cycle != null;
	    }
	 
	 public Iterable<Integer> cycle() {
	        return cycle;
	    }
	 
	 
	public static void main(String[] args) {
		In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyDG.txt");
        Digraph G = new Digraph(in);
        StdOut.println(G);

        DirectedCycle finder = new DirectedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();

	}

}
