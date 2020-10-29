package robertSedwick;

public class EdgeWeightedGraphAdjacencyMatrix4_3_10 {
	 private static final String NEWLINE = System.getProperty("line.separator");
	private final int V;
    private int E;
    private double[][] adj; 
	public EdgeWeightedGraphAdjacencyMatrix4_3_10(int V) {
		this.V=V;
		adj=new double[V][V];
		E=0;
		for(int vertex1 = 0; vertex1 <V; vertex1++) {
            for(int vertex2 = 0; vertex2 < V; vertex2++) {
                adj[vertex1][vertex2] = -1;
            }
        }
		
	}
	public int vertices() {
        return V;
    }

    public int edgesCount() {
        return E;
    }
    public void addEdge(Edge e) {
    	int v=e.either();
    	int w=e.other(v);
    	double weight=e.weight();
    	if(hasEdge(v,w)) {
    		System.out.println("parallel edge between:"+v+"   "+w);
    		return;
    	}
    	adj[v][w]=weight;
    	adj[w][v]=weight;
    	E++;
    	System.out.println(" edge added between:"+v+"   "+w);
    }
    
    public boolean hasEdge(int v, int w) {
        return adj[v][w] != -1;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (double e : adj[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

	public static void main(String[] args) {
		EdgeWeightedGraphAdjacencyMatrix4_3_10 G=new EdgeWeightedGraphAdjacencyMatrix4_3_10(4);
		Edge e1=new Edge(0,1,5);
		G.addEdge(e1);
		
		Edge e2=new Edge(0,3,3);
		G.addEdge(e2);
		
		Edge e3=new Edge(1,0,6);
		G.addEdge(e2);
		
		Edge e4=new Edge(1,2,3);
		G.addEdge(e4);
		
		Edge e5=new Edge(1,3,3);
		G.addEdge(e5);

	}

}
