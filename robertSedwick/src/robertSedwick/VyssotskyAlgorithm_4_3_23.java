package robertSedwick;

import java.util.HashSet;
import java.util.PriorityQueue;

import edu.princeton.cs.algs4.Queue;

//// O(E * (V + E)) = O(E^2)
public class VyssotskyAlgorithm_4_3_23 {
	 public Queue<Edge> minimumSpanningTree(EdgeWeightedGraph G) {
		 PriorityQueue<Edge>putativeTree=new PriorityQueue<Edge>();
		 Queue<Edge> mst = new Queue<>();
		 for(Edge e:G.edges()) {
			 putativeTree.add(e);
			 HashSet<Integer> vertexToSearch = new HashSet<>();
             vertexToSearch.add(e.either());
			 
		 }
		
		 return mst;
		 
	 }

	public static void main(String[] args) {
		EdgeWeightedGraph edgeWeightedGraph1 = new EdgeWeightedGraph(5);
        edgeWeightedGraph1.addEdge(new Edge(0, 1, 0.42));
        edgeWeightedGraph1.addEdge(new Edge(1, 2, 0.12));
        edgeWeightedGraph1.addEdge(new Edge(2, 3, 0.5));
        edgeWeightedGraph1.addEdge(new Edge(3, 4, 0.8));
        edgeWeightedGraph1.addEdge(new Edge(3, 4, 0.82));
        edgeWeightedGraph1.addEdge(new Edge(4, 4, 0.1));
        
        VyssotskyAlgorithm_4_3_23 v=new VyssotskyAlgorithm_4_3_23();
        v.minimumSpanningTree(edgeWeightedGraph1);

	}

}
