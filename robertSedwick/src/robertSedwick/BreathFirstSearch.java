package robertSedwick;
//Runs in O(E + V) time.
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;;

public class BreathFirstSearch {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public BreathFirstSearch(Graph G, int s){
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		bfs(G,s);
	}
	
	private void bfs(Graph G, int s) {
		marked[s]=true;	
		Queue<Integer> queue = new LinkedList<Integer>();
	//	Queue<Integer> queue=new Queue<Integer>():
		queue.add(s);
		while(!queue.isEmpty()) {
			int v=queue.poll();
			for(int w: G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w]=v;
					queue.add(w);
				}
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
	        StdOut.println(G);
	        StdOut.println(".........");
	        int s=3;
	        BreathFirstSearch search=new BreathFirstSearch(G,s);
	        for(int v=0;v<G.V();v++) {
	        	 StdOut.println(s +"  to  "+v+ ":");
	        	 if(search.hasPathTo(v))
	        		 for(int x:search.pathTo(v)) {
	        			 if(x==s)StdOut.print(x);
	        			 else        StdOut.print("-" + x);
	        		 }
	        	 StdOut.print();
	        	 
	        }
		}
}
	        
