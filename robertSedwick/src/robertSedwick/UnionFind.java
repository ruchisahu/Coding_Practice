package robertSedwick;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
	private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;     // number of components
	
	public UnionFind(int n) {
		if (n < 0) throw new IllegalArgumentException();
		count=n;
		parent=new int[n];
		rank=new byte[n];
		for(int i=0;i<n;i++) {
			parent[i]=i;
			rank[i]=0;
		}
	}
	
	public int find(int p) {
		while(p!=parent[p]) {
			 parent[p] = parent[parent[p]];    // path compression by halving
	          p = parent[p];
		}
		return p;
	}
	
	public int count() {
		return count;
		
	}
	
	public boolean connected(int p, int q) {
		 return find(p) == find(q);
		
	}
	
	public void union(int p, int q) {
		int rootP=find(p);
		int rootQ=find(q);
		if(rootP==rootQ)return;
		if(rank[rootP] <rank[rootQ])parent[rootP] = rootQ;
		else if (rank[rootP] > rank[rootQ]) parent[rootQ] = rootP;
		else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
		
		
	}
	

	public static void main(String[] args) {
	/*	 int n = StdIn.readInt();
		 UnionFind uf = new UnionFind(n);
	        while (!StdIn.isEmpty()) {
	            int p = StdIn.readInt();
	            int q = StdIn.readInt();
	            if (uf.find(p) == uf.find(q)) continue;
	            uf.union(p, q);
	            StdOut.println(p + " " + q);
	        }
	        */
		UnionFind uf = new UnionFind(10);
		uf.union(4,3);
		uf.union(3,8);
		uf.union(6,5);
		uf.union(9,4);
		uf.union(2,1);
		uf.union(8,9);
		uf.union(5,0);
		uf.union(7,2);
		uf.union(6,1);
		uf.union(1,0);
		uf.union(6,7);
	        StdOut.println(uf.count() + " components");

	}

}
