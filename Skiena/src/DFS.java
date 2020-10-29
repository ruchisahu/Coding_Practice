
	public class DFS {
	    int[][] graph;
	    int vertices;
	    int[] discovered;
	    int[] parent;
	    int[] entry;
	    int[] exit;
	    int[] processed;
	    int[] reachableAncestor;
	    int[] treeOutDegree;
	    static int time = 0;
	    int cycle;
	    public DFS(int[][] g){
	        graph =  g;
	        vertices = g.length;
	        discovered = new int[vertices];
	        processed = new int[vertices];
	        parent = new int[vertices];
	        parent[0] = -1; //since we are starting our traversal at the root 0
	        entry = new int[vertices];
	        reachableAncestor = new int[vertices];
	        treeOutDegree = new int[vertices];
	        exit = new int[vertices];
	        cycle = 0;

	    }
	    public void traverse(int v){
	        int[] neighbours = graph[v];
	        processVertex(v);
	        for(int i = 0; i < neighbours.length; i++){
	            int n = neighbours[i];
	            if(discovered[n]==0){
	                parent[n] = v;
	                processEdge(v, n);
	                traverse(n);
	            }
	            else if(processed[n] == 0)
	                processEdge(v, n);
	        }
	        processAfterVertex(v);
	    }

	    private void processAfterVertex(int v) {
	        time++;
	        exit[v] = time;
	        processed[v]  = 1;
	        if(parent[v] == -1){
	            if(treeOutDegree[v] > 1)
	                System.out.println((v + 1) + " is a root articulation vertex");
	        }
	        if(reachableAncestor[v] == v && parent[parent[v]]!=-1){
	            System.out.println((parent[v] + 1) + " is a parent articulation vertex");
	            if(treeOutDegree[v] > 0)
	                System.out.println((v+1) + " is a bridge articulation vertex");
	        }
	        int time_v = entry[reachableAncestor[v]];
	        int time_parent = entry[reachableAncestor[parent[v]]];
	        if(time_v < time_parent){
	            reachableAncestor[parent[v]] = reachableAncestor[v];
	        }
	    }

	    private void processEdge(int v, int n) {
	        int edgeType = edgeType(v,n);
	        if(n!=parent[v])
	        {
	            System.out.println("processing edge "+(v+1)+" - " +(n+1));
	            cycle = 1;
	        }
	        if(edgeType==0){
	            treeOutDegree[v] += 1;
	        }
	        else{
	            if(entry[n] < entry[reachableAncestor[v]])
	                reachableAncestor[v] = n;
	        }
	    }

	    private int edgeType(int v, int n){
	        if(parent[v] == n)
	            return 0;
	        return 1;
	    }
	    private void processVertex(int v) {
	       time++;
	        discovered[v] = 1;
	        entry[v] = time;
	        reachableAncestor[v] = v;
	        System.out.println("processing vertex "+(v+1));
	    }

	    private void cycleExists(){
	        if(cycle == 1)
	            System.out.println("cycle exists");
	    }
	    public static void main(String[] args){
	        int[][] graph = {{1,4,5},{0,2,4},{1,3},{2,4},{0,1},{0}};
	        DFS dfs = new DFS(graph);
	        dfs.traverse(0);
	        dfs.cycleExists();
	    }
	}