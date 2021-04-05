import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
	 int vertices;
     LinkedList<Edge>[] adjList;
     ArrayList<Edge> allEdges = new ArrayList<>();

     Graph(int vertices){
         this.vertices = vertices;
         adjList = new LinkedList[vertices];
         for (int i = 0; i <vertices ; i++) {
             adjList[i] = new LinkedList<>();
         }
     }
     public void addEgde(int source, int destination){
         Edge edge = new Edge(source, destination);
         adjList[source].addFirst(edge);
         allEdges.add(edge); //add to total edges
     }
     
     public ArrayList<Edge> AllEdge(){
		return allEdges;
    	 
     }

}
