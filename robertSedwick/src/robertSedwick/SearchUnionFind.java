package robertSedwick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class SearchUnionFind {
	private int source;
	private UnionFind uf;
	
	
	SearchUnionFind(Graph G, int source) {
		this.source=source;
		uf=new UnionFind(G.V());
		for(int v=0;v<G.V();v++) {
			for(int w:G.adj(v)) {
				uf.union(v,w);
			}
		}
       
           
    }

    public boolean marked(int v) {
        return uf.connected(source, v);
    }

    public int count() {
       return uf.count();
    }
	public static void main(String[] args) {
		In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\test1.txt");
        Graph G = new Graph(in);
        StdOut.println(G);
        int s=2;
        StdOut.println("Connected component from:"+s);
        SearchUnionFind d=new SearchUnionFind(G,s);
        for(int v=0;v<G.V();v++) {
        	if(d.marked(v))
        		StdOut.println(v);
        }
        StdOut.println(d.count() + " total components");

	}

}
