/*
 * Given an underected connected graph with n nodes labeled 1..n. A bridge (cut edge) is defined as an edge which, when removed, makes the graph disconnected 
(or more precisely, increases the number of connected components in the graph). Equivalently, an edge is a bridge if and only if it is not contained in any cycle. 
The task is to find all bridges in the given graph. Output an empty list if there are no bridges.

Input:

n, an int representing the total number of nodes.
edges, a list of pairs of integers representing the nodes connected by an edge.
Example 1:

Input: n = 5, edges = [[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]


Output: [[1, 2], [4, 5]]
 */
import java.util.*;

public class CriticalConnection3 {

	    static int time = 0;
	    static final int NIL = -1;
	    static List<Integer[]> ans1 = new LinkedList<>();
	    
	    static class Graph{
	        private int v;
	        private LinkedList<Integer> adj[]; 
	        Graph(int V) 
	        { 
	            v = V; 
	            adj = new LinkedList[V+1]; 
	            for (int i=0; i<V+1; ++i) 
	                adj[i] = new LinkedList(); 
	        }
	        
	        void addEdge(int V, int w) 
	        { 
	            this.adj[V].add(w);
	            this.adj[w].add(V);
	        }
	    } 
	    
	    static void bridgeDfs(Graph g,int u,boolean visited[], int disc[], int low[], int parent[] )
	    {
	        visited[u] = true;
	        disc[u]=low[u]=++time;
	        
	        Iterator<Integer> i = (g.adj[u]).iterator();
	        while(i.hasNext())
	        {
	            int v = i.next();
	            if(!visited[v])
	            {
	                parent[v]=u;
	                bridgeDfs(g,v,visited,disc,low,parent);
	                low[u] = Math.min(low[u],low[v]);
	                if(low[v]>disc[u])
	                    ans1.add(new Integer[]{u,v});
	            }
	            else if(v!=parent[u])
	            {
	                low[u] = Math.min(low[u],disc[v]);
	            }
	        }
	    }
	    
	    static int[][] bridges(int[][] edges,int v)
	    {
	        Graph g = new Graph(v);
	        for(int i=0;i<edges.length;i++)
	        {
	            g.addEdge(edges[i][0],edges[i][1]);
	        }
	        boolean visited[] = new boolean[v+1];
	        int disc[] = new int[v+1];
	        int low[] = new int[v+1];
	        int parent[] = new int[v+1];
	        
	        
	        
	        for(int i=0;i<v;i++)
	        {
	            parent[i]=NIL;
	            visited[i]=false;
	        }
	        

	        for(int i=0;i<v;i++)
	        {
	            if(!visited[i])
	            {
	                bridgeDfs(g,i, visited, disc, low, parent);
	            }
	        }
	        
	        int[][] res = new int[ans1.size()][2];
	        int index=0;
	        for(Integer[] temp: ans1)
	        {
	            res[index][0]=temp[0];
	            res[index][1]=temp[1];
	            index++;
	        }
	        return res;
	    }
	    public static void main(String[] args) {
	        int n=5;
	        
	        // List<List<Integer>> ed = new ArrayList();
	        // ed.add(Arrays.asList(1,2));
	        // ed.add(Arrays.asList(1,3));
	        // ed.add(Arrays.asList(2,3));
	        // ed.add(Arrays.asList(3,4));
	        // ed.add(Arrays.asList(4,5));
	        // ed.add(Arrays.asList(4,6));
	        // ed.add(Arrays.asList(5,6));
	        // ed.add(Arrays.asList(5,7));
	        // ed.add(Arrays.asList(6,7));
	        // ed.add(Arrays.asList(7,8));
	        // ed.add(Arrays.asList(8,9));
	        // ed.add(Arrays.asList(8,10));
	        // ed.add(Arrays.asList(9,10));
	        
	        
	        // int[][] edges = {{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5},{4,6},{5,6},{5,7}, {6, 7}, {7, 8}, {8, 9},{8,10}};

	        int[][] edges = {{1, 2}, {1, 3}, {3, 4}, {1,4},{4,5}};

	        
	        int[][] ans = bridges(edges,n);
	        if(ans.length==0)
	            System.out.print("[]");
	        for(int[] arr : ans)
	            System.out.print(Arrays.toString(arr)+",");
	    }
	}
//Time: O(V+E) (connected graph)
//Space: O(V+E)