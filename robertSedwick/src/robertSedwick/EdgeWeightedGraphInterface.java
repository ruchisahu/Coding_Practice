package robertSedwick;

public interface EdgeWeightedGraphInterface {
	  int vertices();
	    int edgesCount();
	    void addEdge(Edge edge);
	    Iterable<Edge> adj(int vertex);
	    Iterable<Edge> edges();

}
