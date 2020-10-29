
// Java Program to demonstrate adjacency list 
// representation of graphs 
import java.util.LinkedList; 

public class GraphTest
{ 
	static class Graph 
	{ 	int V; 
		LinkedList<Integer> adjListArray[]; 
		Graph(int V) 
		{ 
			this.V = V; 
			adjListArray = new LinkedList[V]; 
			for(int i = 0; i < V ; i++){ 
				adjListArray[i] = new LinkedList<>(); 
			} 
		} 
	} 
	static void addEdge(Graph graph, int src, int dest) 
	{ 
		graph.adjListArray[src].add(dest); 
		graph.adjListArray[dest].add(src); 
	} 
	
	static void printGraph(Graph graph) 
	{	 
		for(int v = 0; v < graph.V; v++) 
		{ 
			System.out.println("Adjacency list of vertex "+ v); 
			System.out.print("head"); 
			for(Integer pCrawl: graph.adjListArray[v]){ 
				System.out.print(" -> "+pCrawl); 
			} 
			System.out.println("\n"); 
		} 
	} 
	public static void main(String args[]) 
	{ 
		// create the graph given in above figure 
		int V = 6; 
		Graph graph = new Graph(V); 
		addEdge(graph, 1, 2); 
		addEdge(graph, 1, 2); 
		addEdge(graph, 1, 3); 
		addEdge(graph, 2, 3); 
		addEdge(graph, 4, 5); 
		addEdge(graph, 5, 6); 
	
		printGraph(graph); 
	} 
} 

