package robertSedwick;
import edu.princeton.cs.algs4.Queue;
//https://algs4.cs.princeton.edu/41graph/EulerianCycle.java

//https://algs4.cs.princeton.edu/41graph/EulerianPath.java.html
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class EulerianHamiltonianCycles_4_1_30 {
	private class Edge {
        int vertex1;
        int vertex2;
        boolean isUsed;

        Edge(int vertex1, int vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            isUsed = false;
        }

        public int otherVertex(int vertex) {
            if (vertex == vertex1) {
                return vertex2;
            } else {
                return vertex1;
            }
        }
    }
	public class EulerCycle {

        public Stack<Integer> getEulerCycle(Graph G) {
        	
        	// A graph with no edges is considered to have an Eulerian cycle
            if (G.E() == 0) {
                return new Stack<>();
            }
			
			
			// Necessary condition: all vertices have even degree
            // (this test is needed or it might find an Eulerian path instead of an Eulerian cycle)
            // An Eulerian path have exactly 2 vertices with even degrees
           
			 for (int v = 0; v < G.V(); v++) 
		            if (G.degree(v) % 2 != 0) {
		            	return null;
		            }
			// create local view of adjacency lists, to iterate one vertex at a time
		        // the helper Edge data type is used to avoid exploring both copies of an edge v-w
		        Queue<Edge>[] adj = (Queue<Edge>[]) new Queue[G.V()];
		        for (int v = 0; v < G.V(); v++)
		            adj[v] = new Queue<Edge>();

		        for (int v = 0; v < G.V(); v++) {
		            int selfLoops = 0;
		            for (int w : G.adj(v)) {
		                // careful with self loops
		                if (v == w) {
		                    if (selfLoops % 2 == 0) {
		                        Edge e = new Edge(v, w);
		                        adj[v].enqueue(e);
		                        adj[w].enqueue(e);
		                    }
		                    selfLoops++;
		                }
		                else if (v < w) {
		                    Edge e = new Edge(v, w);
		                    adj[v].enqueue(e);
		                    adj[w].enqueue(e);
		                }
		            }
		        }
		        // initialize stack with any non-isolated vertex
		        int s = nonIsolatedVertex(G);
		        Stack<Integer> stack = new Stack<Integer>();
		        stack.push(s);

		        // greedily search through edges in iterative DFS style
		        Stack<Integer> cycle = new Stack<Integer>();
		        while (!stack.isEmpty()) {
		            int v = stack.pop();
		            while (!adj[v].isEmpty()) {
		                Edge edge = adj[v].dequeue();
		                if (edge.isUsed) continue;
		                edge.isUsed = true;
		                stack.push(v);
		                v = edge.otherVertex(v);
		            }
		            // push vertex with no more leaving edges to cycle
		            cycle.push(v);
		        }

		        // check if all edges are used
		        if (cycle.size() == G.E() + 1)
		            return cycle;
		        else
		        	return null;
         

        }
	}
	private int nonIsolatedVertex(Graph graph) {
        int nonIsolatedVertex = -1;

        for(int vertex = 0; vertex < graph.V(); vertex++) {
            if (graph.degree(vertex) > 0) {
                nonIsolatedVertex = vertex;
                break;
            }
        }

        return nonIsolatedVertex;
    }
	private void printCycle(Stack<Integer> eulerCycle) {
        StdOut.println("Euler cycle:");

        while (!eulerCycle.isEmpty()) {
            int vertex = eulerCycle.pop();

            if (!eulerCycle.isEmpty()) {
                StdOut.print(vertex + "-" + eulerCycle.peek());

                if (eulerCycle.size() > 1) {
                    StdOut.print(" ");
                }
            }
        }
        StdOut.println();
    }



	public static void main(String[] args) {
		EulerianHamiltonianCycles_4_1_30 exercise30 = new EulerianHamiltonianCycles_4_1_30();
	        EulerCycle eulerCycle = exercise30.new EulerCycle();

	        Graph graphWithEulerPath1 = new Graph(4);
	        graphWithEulerPath1.addEdge(0, 1);
	        graphWithEulerPath1.addEdge(1, 2);
	        graphWithEulerPath1.addEdge(2, 3);
	        graphWithEulerPath1.addEdge(3, 0);
	        graphWithEulerPath1.addEdge(3, 2);
	        
	        Stack<Integer> eulerCycle1 = eulerCycle.getEulerCycle(graphWithEulerPath1);

	        if (eulerCycle1 != null) {
	            exercise30.printCycle(eulerCycle1);
	        } else {
	            StdOut.println("There is no Eulerian cycle");
	        }
	        StdOut.println("Expected: There is no Eulerian cycle\n");

	}

}
