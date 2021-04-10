package robertSedwick;
//ElogE
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class KruskalMST {
	private double weight;
	private Queue<Edge> mst=new Queue<Edge>();
	
	public KruskalMST(EdgeWeightedGraph G) {
		PriorityQueue<Edge>pq=new PriorityQueue<Edge>();
		for(Edge e: G.edges()) {
			pq.add(e);
		}
		//union find greedy algo
		UnionFind uf=new UnionFind(G.vertices());
		while(!pq.isEmpty() && mst.size() < G.vertices()-1) {
			Edge e=pq.poll();
			int v=e.v;
			int w=e.u;
			if(uf.find(v)!=uf.find(w)) {  // v-w does not create a cycle
				uf.union(v,w);
				mst.enqueue(e);
				weight+=e.weight();
			}
		}
		
	}
	
	public Iterable<Edge> edges(){
		return mst;
	}
	
	 public double weight() {
	        return weight;
	    }

	public static void main(String[] args) {
		In in = new In("C:\\Users\\sankalpg\\Coding_Practice\\robertSedwick\\src\\robertSedwick\\tinyEWG.txt");
	        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
	        KruskalMST mst = new KruskalMST(G);
	        for (Edge e : mst.edges()) {
	            StdOut.println(e);
	        }
	        StdOut.printf("%.5f\n", mst.weight());
	    }

	}


