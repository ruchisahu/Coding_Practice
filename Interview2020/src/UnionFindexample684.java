

public class UnionFindexample684 {
	 int MAX_EDGE_VAL = 1000;
	    
	 class UnionFind {
	        private int count = 0;
	        private int[] parent, rank;
	        
	        public UnionFind(int n) {
	            count = n;
	            parent = new int[n];
	            rank = new int[n];
	            for (int i = 0; i < n; i++) {
	                parent[i] = i;
	            }
	        }
	        
	        public int find(int p) {
	        	while (p != parent[p]) {
	                parent[p] = parent[parent[p]];    // path compression by halving
	                p = parent[p];
	            }
	            return p;
	        }
	        
	        public boolean union(int p, int q) {
	            int rootP = find(p);
	            int rootQ = find(q);
	            if (rootP == rootQ)
	            	return false;
	            if (rank[rootQ] > rank[rootP]) {
	                parent[rootP] = rootQ;
	            }
	            else {
	                parent[rootQ] = rootP;
	                if (rank[rootP] == rank[rootQ]) {
	                    rank[rootP]++;
	                }
	            }
				return true;
	           
	        }
	        
	        public int count() {
	            return count;
	        }
	    }
	    
	 public int[] findRedundantConnection(int[][] edges) {
	        UnionFind uf=new UnionFind(MAX_EDGE_VAL + 1);
	        for (int[] edge: edges) 
	        {
	            if(!uf.union(edge[0], edge[1])) 
	            	return edge;
	        }
	         throw new AssertionError();
	    }
	
	

	public static void main(String[] args) {
		UnionFindexample684 u=new UnionFindexample684();
		int[][]N= {{1,2},
		 {1,3},
		 {2,3}};
		System.out.println(u.findRedundantConnection(N));

	}

}
