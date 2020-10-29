package robertSedwick;

import edu.princeton.cs.algs4.StdOut;

public class Bridge {
	 private int bridges;      // number of bridges
	    private int cnt;          // counter
	    private int[] pre;        // pre[v] = order in which dfs examines v
	    private int[] low;        // low[v] = lowest preorder of any vertex connected to v

	    public Bridge(Graph G) {
	        low = new int[G.V()];
	        pre = new int[G.V()];
	        for (int v = 0; v < G.V(); v++)
	            low[v] = -1;
	        for (int v = 0; v < G.V(); v++)
	            pre[v] = -1;
	        
	        for (int v = 0; v < G.V(); v++)
	            if (pre[v] == -1)
	                dfs(G, v, v);
	    }

	    public int components() { return bridges + 1; }

	    private void dfs(Graph G, int u, int v) {
	        pre[v] = cnt++;
	        low[v] = pre[v];
	        for (int w : G.adj(v)) {
	            if (pre[w] == -1) {
	                dfs(G, v, w);
	                low[v] = Math.min(low[v], low[w]);
	                if (low[w] == pre[w]) {
	                    StdOut.println(v + "-" + w + " is a bridge");
	                    bridges++;
	                }
	            }

	            // update low number - ignore reverse of edge leading to v
	            else if (w != u)
	                low[v] = Math.min(low[v], pre[w]);
	        }
	    }
	public static void main(String[] args) {
		 Graph graph2 = new Graph(6);
		 graph2.addEdge(0, 1);
	        graph2.addEdge(2, 1);
	        graph2.addEdge(0, 2);
	        graph2.addEdge(3, 5);
	        graph2.addEdge(4, 5);
	        graph2.addEdge(3, 4);
	        graph2.addEdge(1, 5);
		 Bridge bridge = new Bridge(graph2);
	        StdOut.println("Edge connected components = " + bridge.components());
	        
	        Graph graph3 = new Graph(7);
	        graph3.addEdge(0, 1);
	        graph3.addEdge(2, 1);
	        graph3.addEdge(0, 2);
	        graph3.addEdge(3, 6);
	        graph3.addEdge(4, 6);
	        graph3.addEdge(3, 4);
	        graph3.addEdge(1, 5);
	        graph3.addEdge(5, 6);
	        Bridge bridge1 = new Bridge(graph3);
	        StdOut.println("Edge connected components = " + bridge1.components());

	}

}
