// one solution dfs in robertswedwick/dfsconnectedcommonent

public class ConnectedComponents323 {
	//sol2: union find
	
	public static int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int r1 = find(roots, edges[i][0]);
            int r2 = find(roots, edges[i][1]);
            
            if (r1 != r2) {
                roots[r1] = r2;
                n--;
            }
        }
        
        return n;
    }
    
    private static int find(int[] roots, int key) {
        while (roots[key] != key) {
            key = roots[key];
        }
        
        return key;
    }


	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(countComponents(n, edges));

	}

}
