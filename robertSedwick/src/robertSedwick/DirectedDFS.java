package robertSedwick;

import java.util.*;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DirectedDFS {
	public boolean[] marked;
	int count=0;
	//Computes the vertices in digraph G that are reachable from the source vertex s.
	DirectedDFS(Digraph G, int s){
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	
	//Computes the vertices in digraph G that are connected to any of the source vertices sources.
	DirectedDFS(Digraph G, Iterable<Integer> sources){
		marked=new boolean[G.V()];
		for(int s: sources) {
			if(!marked[s])
			dfs(G,s);
		}
		
	}
	private void dfs(Digraph G, int v) {
		count++;
		marked[v]=true;
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				dfs(G,w);
			}
		}
		
		
	}
	public boolean marked(int v) {
		return marked[v];
	}
	
	public int count() {
        return count;
    }
	public static void main(String[] args) {
		In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyDG.txt");
        Digraph G = new Digraph(in);

        // read in sources from command-line arguments
        List<Integer> sources = new ArrayList<Integer>();
      /*  for (int i = 1; i < args.length; i++) {
            int s = Integer.parseInt(args[i]);
            sources.add(s);
        }
*/
        sources.add(2);
        sources.add(3);
        sources.add(10);
        // multiple-source reachability
        DirectedDFS dfs = new DirectedDFS(G, sources);

        // print out vertices reachable from sources
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) 
            	{
            	StdOut.print(v + " ");
            	
            	}
            StdOut.print("    ");
        }
        StdOut.println();
    }

		

	}


