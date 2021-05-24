import java.util.*;


public class MinimumTimetoCollectApplesTree1443 {
	int ans = 0;
    public int minTime(int n, int[][] edges, boolean[] hasApple) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, graph, hasApple, new HashSet<>());
        return ans;
    }
    
    private boolean dfs(int node,Map<Integer, List<Integer>> graph, boolean[] hasApple, Set<Integer> seen) {
        if(seen.contains(node)) return false;
        seen.add(node);
        for(int next : graph.get(node)) {
            if(dfs(next, graph, hasApple, seen)) {
                hasApple[node]= true;
                ans += 2;
            }
        }
        seen.remove(node);
        return hasApple[node];
    }

	public static void main(String[] args) {
		MinimumTimetoCollectApplesTree1443 m=new MinimumTimetoCollectApplesTree1443();
		int n = 7;
		int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}}; 
		boolean[] hasApple= {false,false,true,false,true,true,false};
		m.minTime(n, edges, hasApple);

	}

}
