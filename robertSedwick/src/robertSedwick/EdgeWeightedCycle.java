package robertSedwick;

import java.util.HashSet;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class EdgeWeightedCycle {
	
	private boolean visited[];
    private Edge[] edgeTo;
    private Stack<Edge> cycle; // edges on  a cycle (if one exists)
    private boolean[] onStack; // vertices on recursive call stack
    private HashSet<Edge> visitedEdges;
    private boolean cycleFound;

    public EdgeWeightedCycle(EdgeWeightedGraph edgeWeightedGraph) {
    	 visited = new boolean[edgeWeightedGraph.vertices()];
         edgeTo = new Edge[edgeWeightedGraph.vertices()];
         onStack = new boolean[edgeWeightedGraph.vertices()];
         visitedEdges = new HashSet<>();
         cycleFound = false;
         cycle = null;

        for(int vertex = 0; vertex < edgeWeightedGraph.vertices(); vertex++) {
            if (cycleFound) {
                break;
            }

            if (!visited[vertex]) {
                dfs(edgeWeightedGraph, vertex);
            }
        }
    }
    
    private void dfs(EdgeWeightedGraph edgeWeightedGraph, int vertex) {
        onStack[vertex] = true;
        visited[vertex] = true;

        for(Edge neighbor : edgeWeightedGraph.adj(vertex)) {
            if (visitedEdges.contains(neighbor)) {
                continue;
            }

            visitedEdges.add(neighbor);
            int neighborVertex = neighbor.other(vertex);

            if (hasCycle()) {
                return;
                
            } else if (!visited[neighborVertex]) {
                edgeTo[neighborVertex] = neighbor;
                dfs(edgeWeightedGraph, neighborVertex);
                
            } else if (onStack[neighborVertex]) {
                cycleFound = true;
                cycle = new Stack<>();

                for(int currentVertex = vertex; currentVertex != neighborVertex;
                    currentVertex = edgeTo[currentVertex].other(currentVertex)) {
                    cycle.push(edgeTo[currentVertex]);
                }

                cycle.push(neighbor);
            }
        }

        onStack[vertex] = false;
    }
   
    public boolean hasCycle() {
        return cycle != null;
    }

    public Stack<Edge> cycle() {
        return cycle;
    }
    public static void main(String[] args) {
    	 In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\tinyEWG.txt");
    	 EdgeWeightedGraph G = new EdgeWeightedGraph(in);
        StdOut.println(G);

        EdgeWeightedCycle finder = new EdgeWeightedCycle(G);
        if (finder.hasCycle()) {
            StdOut.print("Directed cycle: ");
            for (Edge v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

        else {
            StdOut.println("No directed cycle");
        }
        StdOut.println();

	}

}
