package robertSedwick;

import java.util.*;

import edu.princeton.cs.algs4.In;

public class EdgeWeightedDigraph {
	private final int vertices;
    private int edges;
    private List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int vertices) {
        this.vertices = vertices;
        edges = 0;
        adj = (List<DirectedEdge>[]) new List[vertices];

        for(int vertex = 0; vertex < vertices; vertex++) {
            adj[vertex] = new ArrayList<>();
        }
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int edges = in.readInt();

        if (edges < 0) {
            throw new IllegalArgumentException("Number of edges must be nonnegative");
        }

        for(int i = 0; i < edges; i++) {
            int vertexFrom = in.readInt();
            int vertexTo = in.readInt();
            double weight = in.readDouble();

            DirectedEdge edge = new DirectedEdge(vertexFrom, vertexTo, weight);
            addEdge(edge);
        }
    }

    public int V() {
        return vertices;
    }

    public int edgesCount() {
        return edges;
    }

    public int outdegree(int vertex) {
        return adj[vertex].size();
    }

    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        edges++;
    }

    public Iterable<DirectedEdge> adj(int vertex) {
        return adj[vertex];
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> bag = new ArrayList<>();

        for(int vertex = 0; vertex < vertices; vertex++) {
            for(DirectedEdge edge : adj[vertex]) {
                bag.add(edge);
            }
        }

        return bag;
    }

    public EdgeWeightedDigraph reverse() {
        EdgeWeightedDigraph reverse = new EdgeWeightedDigraph(vertices);

        for(int vertex = 0; vertex < vertices; vertex++) {
            for(DirectedEdge edge : adj(vertex)) {
                int neighbor = edge.to();
                reverse.addEdge(new DirectedEdge(neighbor, vertex, edge.weight()));
            }
        }

        return reverse;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(int vertex = 0; vertex < V(); vertex++) {
            stringBuilder.append(vertex).append(": ");

            for(DirectedEdge neighbor : adj(vertex)) {
                stringBuilder.append(neighbor).append(" ");
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
