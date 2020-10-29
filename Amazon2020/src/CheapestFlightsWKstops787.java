import java.util.*;

/*
 * There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.
Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.
Example 1:
Input: 
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
 */
//https://massivealgorithms.blogspot.com/2018/04/leetcode-787-cheapest-flights-within-k.html
//Dijkstra
public class CheapestFlightsWKstops787 {
	 public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
	        Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
	        for (int[] f : flights) {
	            if (!prices.containsKey(f[0])) 
	            	prices.put(f[0], new HashMap<>());
	            
	            prices.get(f[0]).put(f[1], f[2]);
	        }
	        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
	        pq.add(new int[] {0, src, k + 1});
	        while (!pq.isEmpty()) {
	            int[] top = pq.remove();
	            int price = top[0];
	            int city = top[1];
	            int stops = top[2];
	            if (city == dst) return price;
	            if (stops > 0) {
	                Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
	                for (int a : adj.keySet()) {
	                    pq.add(new int[] {price + adj.get(a), a, stops - 1});
	                }
	            }
	        }
	        return -1;
	    }
	 //0(KN)
	 public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
	        //dp[i][j] denotes the cheapest price within i-1 stops, stop in j city
	        long[][] dp = new long[K+2][n];
	        for (long[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
	        dp[0][src] = 0;
	        for (int i = 1; i < K+2; i++) {
	            dp[i][src] = 0;
	            for (int[] f : flights) {
	                dp[i][f[1]] = Math.min(dp[i][f[1]], dp[i-1][f[0]] + f[2]);
	            }
	        }
	        return dp[K+1][dst] == Integer.MAX_VALUE ? -1 : (int)dp[K+1][dst];
	    }
	 //bellman ford
	 public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
	        int[] dist = new int[n];
	        Arrays.fill(dist, Integer.MAX_VALUE);
	        dist[src] = 0;
	        for (int i = 0; i <= K; i++) {
	            int[] tmpDist = Arrays.copyOf(dist, dist.length);
	            for (int[] edge : flights) {
	                int u = edge[0];
	                if (dist[u] == Integer.MAX_VALUE) continue;
	                int v = edge[1];
	                int w = edge[2];
	                tmpDist[v] = Math.min(tmpDist[v], dist[u] + w);
	            }
	            dist = tmpDist;
	        }
	        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
