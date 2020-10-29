/*
 * find(x): find the root of x
union(x, y): merge two clusters
Path compression：make tree flat
 */
public class UnionFind {
	
	   
	    private int[] parent;
	    private int[] rank;
	    
	    public UnionFind(int n) {
	        parent = new int[n + 1];
	        rank = new int[n + 1];
	        for (int i = 0; i < n + 1; i++) {
	            parent[i] = i; 
	            rank[i] = 0;
	        }
	    }
	   
	    public int find(int node) {
	       
	        if (node != parent[node]) {
	         
	            parent[node] = find(parent[node]);
	        }
	        return parent[node];
	        
	        

	    }
	    
	    public boolean union(int u, int v) {
	        int parent_u = find(u);
	        int parent_v = find(v);
	        if (parent_u == parent_v) {
	         
	            return false;
	        }
	       
	        if (rank[parent_u] > rank[parent_v]) {
	            parent[parent_v] = parent_u;
	        } else if (rank[parent_u] < rank[parent_v]) {
	            parent[parent_u] = parent_v;
	        } else {
	            
	            parent[parent_v] = parent_u;
	           
	            rank[parent_u] += 1;
	        }
	        return true;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
