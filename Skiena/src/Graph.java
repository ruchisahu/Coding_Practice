import java.util.*;

public class Graph
{
	List<LinkedList> adj;
    int vertices;
    int[][] edges;
    public Graph(int v, int[][] e){
       adj = new ArrayList<>();
        vertices = v;
        edges = e;
       construct();
       print();
    }

    private void construct() {
        for(int i = 0; i < vertices; i++)
            adj.add(new LinkedList());
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            adj.get(edge[0]).add(edge[1]);
        }
    }

    private void print() {
    	for(int i = 0; i < adj.size(); i++) {
    		System.out.println(i+"-> "+adj.get(i));
    	}
    }

    public static void main(String[] args){
        int vertices = 5;
        int[][] edges = {{0,3},{0,4}, {1,2}, {1,4},{2,3},{3,4}};
        Graph graph = new Graph(vertices, edges);

    }
}