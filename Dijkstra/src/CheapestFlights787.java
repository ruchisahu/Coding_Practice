import java.util.*;

//https://leetcode.com/problems/cheapest-flights-within-k-stops/
public class CheapestFlights787 {
	
	 public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
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
	 ////0(KN)
	 public static int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
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
		int src=0;
		int dst=2;
		int k=2;
		int n=3;
		int[][] flights= {{0,1,100},{1,2,100},{0,2,500}};
		System.out.println(findCheapestPrice1(n, flights,src, dst, k));

	}

}
