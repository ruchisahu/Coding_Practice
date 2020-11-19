import java.util.HashSet;

//cracking the coding interview chap 4 ques-1:Given a directed graph, design an algorithm to find out whether there is a route between two nodes
public class RouteBetweenNodes {
	static boolean search(Graph G, int v, int w) {
		HashSet<Integer> visited=new HashSet<>();
		
		return dfs(G,v,w,visited);
		
	}

	private static boolean dfs(Graph g, int v, int w, HashSet<Integer> visited) {
		
		if(v==w)return true;
		visited.add(v);
		for(int d:g.adj(v)) {
			if(!visited.contains(d)) {
				if(dfs(g,d,w,visited)) {
					return true;
				}
			}
		}
				
		return false;
		
	}

	public static void main(String[] args) {
		Graph d=new Graph(5);
		d.addEdge(1, 2);
		d.addEdge(3, 4);
		d.addEdge(2, 3);
		System.out.println(d.hasEdge(d,1,3));
		System.out.println(search(d,1,3));
		
		System.out.println(d.hasEdge(d,1,2));
		System.out.println(search(d,1,2));

	}

}
