import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class removeStones {
	class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        public UnionFind(int n) { // for problem 200
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) { // path compression
            // only the rank of the root matters, used in union op.
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) { // union with rank
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else {
                    parent[rootx] = rooty;
                    if (rootx == rooty)
                        rank[rooty] += 1;
                }
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int removeStones(int[][] stones) {
        // if any two points are on the same column or row, they are connected as a
        // edge.
        // find connected component, and remove all but one.
        // count the number of disjoint components.
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(stones[i], stones[j]))
                    uf.union(i, j);
            }
        }
        return n - uf.getCount();

    }

    private boolean isConnected(int[] p1, int[] p2){
        return p1[0] == p2[0] || p1[1] == p2[1];
    }
    


	public static void main(String[] args) {
		removeStones r=new removeStones();
		int[][] stones= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};   //5
				System.out.println(r.removeStones(stones));

	}

}
