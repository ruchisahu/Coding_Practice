import java.util.*;


public class BFS {
	    int[][] graph;
	    int[] discovered;
	    int[] processed;
	    int[] parent;
	    char[] colour;
	    int bipartite;
	    int vertices;
	    Deque q; 
	   // Queue q;
	    static int edges;
	    public BFS(int[][] g){
	        vertices = g.length;
	        System.out.println("vertices="+vertices);
	        graph = g;
	        discovered = new int[vertices];
	        processed = new int[vertices];
	        parent = new int[vertices];
	      //  q = new Queue();
	        q= new ArrayDeque<Integer>();
	        edges = 0;
	        colour = new char[vertices];
	        bipartite = 1;
	    }

	    public void findPath(int v){
	        System.out.print((v+1)+"-");
	        if(parent[v]!=-1)
	            findPath(parent[v]);
	    }

	    private void traverse(int source) {
	        discovered[source] = 1;
	        parent[source] = -1;
	       // q.enqueue(source);
	        q.add(source);
	        while(q.size() != 0){
	           // int v = q.dequeue();
	        	int v=(int) q.poll();
	            processVertex(v);
	            int[] neighbours = graph[v];
	            for(int i = 0; i< neighbours.length; i++){
	                int neighbour = neighbours[i];
	                if(processed[neighbour] == 0)
	                    processEdge(v,neighbour);
	                if(discovered[neighbour] == 0) {
	                   // q.enqueue(neighbours[i]);
	                	q.add(neighbours[i]);
	                    discovered[neighbour] = 1;
	                    parent[neighbour] = v;
	                }
	            }
	            processed[v] = 1;
	        }
	    }

	    private void findConnectedComponents(){
	        int c = 0;
	        for(int i = 0; i < vertices; i++){
	            if(discovered[i] == 0){
	                c++;
	                System.out.println("component "+c);
	                traverse(i);
	            }
	        }
	    }

	    public void isBipartite() {
	        for(int i = 0; i < vertices; i++){
	            if(discovered[i] == 0){
	                colour[i] = 'w';
	                traverse(i);
	            }
	        }
	        System.out.println(bipartite == 1? "two colouring possible": "two colouring not possible");
	    }

	    private void processEdge(int v, int neighbour) {
	        if(colour[neighbour] == colour[v])
	        {
	            bipartite = 0;
	            System.out.println("bipartite not possible");
	        }
	        else
	            colour[neighbour] = complement(colour[v]);

	        System.out.println("processing edge "+ (v+1)+" "+(neighbour+1));
	        edges++;
	    }

	    private char complement(char c) {
	        if(c=='w')
	            return 'b';
	        return 'w';
	    }

	    private void processVertex(int v) {
	        System.out.println("vertex "+(v+1));
	    }

	    public static void main(String[] args){
	        int[][] graph = {{3,4,5},{4},{5},{0},{0,1},{0,2}};
	        BFS bfs = new BFS(graph);
	        //bfs.traverse(0);
	        //System.out.println(edges+" edges");
	        //bfs.findPath(5);
	        //bfs.findConnectedComponents();
	        bfs.isBipartite();

	    }

	}