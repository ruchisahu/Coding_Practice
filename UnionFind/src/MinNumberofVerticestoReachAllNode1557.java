import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinNumberofVerticestoReachAllNode1557 {
	public static int findParent(int[] parent, int i) {
        if(parent[i] == i) return i;
        return parent[i] = findParent(parent, parent[i]);
    }
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] parent = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        for(int i = 0; i < edges.size(); i++) {
            List<Integer> curr = edges.get(i);
            int sv = curr.get(0);
            int ev = curr.get(1);
            if(visited[ev]) continue;
            int p1 = findParent(parent, sv);
            int p2 = findParent(parent, ev);
            parent[p2] = p1; 
            visited[ev] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) if(parent[i] == i) ans.add(i);
        return ans;
    }


	public static void main(String[] args) {
		int n = 6;
		
		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		//int[][] twoDArray= {{0,1},{0,2},{2,5},{3,4},{4,2}};
		
		findSmallestSetOfVertices(n,edges);

	}

}
