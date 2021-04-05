import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OptimizedDisjointSet {
	int[] parent;
	int[] rank;
	int size;
	int component;
	public void disjointSets(Graph g,int size){
		this.size=size;
		this.component=size;
		rank=new int[size];
		parent=new int[size];
		for (int i = 0; i < size; i++) {
		      parent[i] = i; // Link to itself (self root)
		      rank[i] = 1; // Each component is originally of size one
		    }
		for(int i=0;i<g.AllEdge().size();i++) {
			Edge edge=g.AllEdge().get(i);
			int x=find(edge.source);
			int y=find(edge.destination);
		
		if(x!=y) {
			union(x,y);
			component--;
		}
		}
		printSets();	
		}
	private void union(int x, int y) {
		int x_set = find(x);
        int y_set = find(y);
        if(rank[x_set]>rank[y_set]) {
        	parent[y_set]=parent[x_set];
        	rank[x_set]+=rank[y_set];
        }
        else {
        	parent[x_set]=parent[y_set];
        	rank[y_set]+=rank[x_set];
        }
		
	}
	
	//path compression
	 public int find(int vertex){
		 if(parent[vertex]!=vertex) {
			 parent[vertex]=find(parent[vertex]);
		 }
		return parent[vertex];
		}
	 public void printSets(){
         //Find different Sets
         HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
         for (int i = 0; i <parent.length ; i++) {
             if(map.containsKey(parent[i])){
                 ArrayList<Integer> list = map.get(parent[i]);
                 list.add(i);//add vertex
                 map.put(parent[i],list);
             }else{
                 ArrayList<Integer> list = new ArrayList<>();
                 list.add(i);
                 map.put(parent[i],list);
             }
         }
         //Print the Different sets
         Set<Integer> set = map.keySet();
         Iterator<Integer> iterator = set.iterator();
         while(iterator.hasNext()){
             int key = iterator.next();
             System.out.println("Set Id: " + key + " elements: " + map.get(key));
         }
         System.out.println("component:" +component);
     }

	public static void main(String[] args) {
		int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 3);
        graph.addEgde(4, 5);
        System.out.println("Disjoint Sets: ");
        OptimizedDisjointSet d=new OptimizedDisjointSet();
        d.disjointSets(graph,vertices);

	}

}
