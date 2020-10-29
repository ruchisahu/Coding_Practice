import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CriricalEdges1489 {
	 public static List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
	        List<Integer> critcal = new ArrayList();
	        List<Integer> pseudo = new ArrayList();
			
	        HashMap<int[],Integer> map = new HashMap();
	         for(int i=0;i<edges.length;i++) map.put(edges[i],i);
			 
	        Arrays.sort(edges,(e1,e2)->e1[2]-e2[2]);
	        int min = minSpanningTree(edges,null,null,n);
	        
	        for(int i=0;i<edges.length;i++){
	            if(minSpanningTree(edges,null,edges[i],n) > min)
	                critcal.add(map.get(edges[i]));
	            else{
	                if(minSpanningTree(edges,edges[i],null,n) == min)
	                  pseudo.add(map.get(edges[i]));  
	            }
	        }
	        return Arrays.asList(critcal,pseudo);
	     }
	    
	    public static int minSpanningTree(int[][] edges, int[] incl, int[] excl, int n){
	        int[] parent = new int[n];
	        int cost = 0;
	        int edge = 0;
	        for(int i=0;i<n;i++) parent[i] = i;
	        
	        if(incl != null){
	           int u = find(parent,incl[0]);
	           int v =  find(parent,incl[1]);
	            parent[v] = u;
	            edge++;
	            cost+= incl[2];
	        }
	        
	        for(int i=0; i<edges.length; i++){
	             if(excl == edges[i]) continue;
	            int u = find(parent,edges[i][0]);
	            int v = find(parent,edges[i][1]);
	            
	             if(u == v) continue;
	            
	             parent[v] = u;
	             edge++;
	             cost+=edges[i][2];
	            if(edge == n-1) return cost;
	        }
	         return (edge == n-1) ? cost : Integer.MAX_VALUE;
	    }
	    
	      public static int find(int[] parent, int u){
	          if(parent[u] == u) return u;
	          return parent[u] = find(parent,parent[u]);
	      }
	
	public static void main(String[] args) {
		int n=5;
		int[][] edges= {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
		System.out.println(findCriticalAndPseudoCriticalEdges(n,edges));

	}

}
