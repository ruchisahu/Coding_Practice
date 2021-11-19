package robertSedwick;
/// (V+E)
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class DFS_detectCycle {
	private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;

	
	public DFS_detectCycle(Graph G){
		 if (hasSelfLoop(G)) return;
	        if (hasParallelEdges(G)) return;
	        marked = new boolean[G.V()];
	        edgeTo = new int[G.V()];
	        for (int v = 0; v < G.V(); v++)
	            if (!marked[v])
	                dfs(G, -1, v);
	}

	private void dfs(Graph G, int u, int v) {
		marked[v] = true;
        for (int w : G.adj(v)) {

            // short circuit if cycle already found
            if (cycle != null) return;

            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, v, w);
            }

            // check for cycle (but disregard reverse of edge leading to v)
            else if (w != u) {
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
    }
	public boolean marked(int w) {
		return marked[w];
	}
	// does this graph have a self loop?
    // side effect: initialize cycle to be self loop
    private boolean hasSelfLoop(Graph G) {
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }
        }
        return false;
    }
    
 // does this graph have two parallel edges?
    // side effect: initialize cycle to be two parallel edges
    private boolean hasParallelEdges(Graph G) {
        marked = new boolean[G.V()];

        for (int v = 0; v < G.V(); v++) {

            // check for parallel edges incident to v
            for (int w : G.adj(v)) {
                if (marked[w]) {
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                    return true;
                }
                marked[w] = true;
            }

            // reset so marked[v] = false for all v
            for (int w : G.adj(v)) {
                marked[w] = false;
            }
        }
        return false;
    }
    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
	public static void main(String[] args) {
		In in = new In("C:\\Users\\sankalpg\\Coding_Practice\\robertSedwick\\src\\robertSedwick\\test1.txt");
        Graph G = new Graph(in);
        DFS_detectCycle finder = new DFS_detectCycle(G);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("Graph is acyclic");
        }
    }


}

