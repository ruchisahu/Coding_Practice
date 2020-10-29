package robertSedwick;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;



 
// * finding path api
 //* Path(Graph G,int s)
 //* boolean hasPathTo(int v)  //path from  s to v
 //* Iterable<Integer> pathTo(int v)  path from s to v
 
public class DepthfirstPath {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	DepthfirstPath(Graph G, int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		dfs(G,s);
	}
	private void dfs(Graph G, int v) {
		marked[v]=true;	
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G,w);
				}
			}
	}
	boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){    //path from v to s
		if(!hasPathTo(v))return null;
		Stack<Integer>path=new Stack<Integer>();
		for(int x=v; x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
	 public static void main(String[] args) {
	In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyCG.txt");
    Graph G = new Graph(in);
    // StdOut.println(G);

    int s = 1;
    DepthfirstPath bfs = new DepthfirstPath(G, s);

    for (int v = 0; v < G.V(); v++) {
        if (bfs.hasPathTo(v)) {
            StdOut.printf("%d to %d :  ", s, v);
            for (int x : bfs.pathTo(v)) {
                if (x == s) StdOut.print(x);
                else        StdOut.print("-" + x);
            }
            StdOut.println();
        }

        else {
            StdOut.printf("%d to %d (-):  not connected\n", s, v);
        }

    }

	}

}
