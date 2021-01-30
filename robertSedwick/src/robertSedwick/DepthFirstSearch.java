package robertSedwick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/*
 * basic search api
 * class search{
 * Search(Graph G,int s)  //find vertices connected to source vertex s
 * boolean marked(int v)  // v connected to s
 * int count //how many vertices connected to s.
 * }
 */
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph G, int s ){
		marked=new boolean[(G.V())];
		dfs(G,s);
	}

	private void dfs(Graph G, int v) {
		marked[v]=true;		
		count++;
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				dfs(G,w);
				count++;  //count connected component
			
				}
			
			
		}
	}
	public boolean marked(int w) {
		return marked[w];
	}

	public static void main(String[] args) {
		In in = new In("C:\\Users\\sankalpg\\Coding_Practice\\robertSedwick\\src\\robertSedwick\\test1.txt");
        Graph G = new Graph(in);
        StdOut.println(G);
        int s=2;
        StdOut.println("Connected component from:"+s);
        DepthFirstSearch d=new DepthFirstSearch(G,s);
        for(int v=0;v<G.V();v++) {
        	if(d.marked(v))
        		StdOut.println(v);
        }
        
        int s1=5;
        StdOut.println("Connected component from:"+s1);
        DepthFirstSearch d1=new DepthFirstSearch(G,s1);
        for(int v=0;v<G.V();v++) {
        	if(d1.marked(v))
        		StdOut.println(v);
        }

	}

}
