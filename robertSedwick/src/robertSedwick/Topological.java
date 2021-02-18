package robertSedwick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;


public class Topological {
	private Iterable<Integer> order;  // topological order
    private int[] rank;               // rank[v] = rank of vertex v in order

	public Topological(Digraph G) {
		DirectedCycle finder=new DirectedCycle(G);
		if(!finder.hasCycle()) {
			DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
            rank = new int[G.V()];
            int i = 0;
            for (int v : order)
                rank[v] = i++;
        
		}
	}
	

	public Iterable<Integer> order() {
        return order;
    }
	
	
	public boolean hasOrder() {
        return order != null;
    }
	public int rank(int v) {
        
        if (hasOrder()) return rank[v];
        else            return -1;
    }
	
	 public static void main(String[] args) {
		 String filename  = "C:\\Users\\sankalpg\\Coding_Practice\\robertSedwick\\src\\robertSedwick\\routes.txt";
	        String delimiter = " ";
	        SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
	        Topological topological = new Topological(sg.digraph());
	        for (int v : topological.order()) {
	            StdOut.println(sg.nameOf(v));
	        }
	    }
	

}
