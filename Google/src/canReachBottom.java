import java.util.*;


//https://leetcode.com/discuss/interview-question/1097545/Google-or-Onsite-Interview-3-questions
public class canReachBottom {
	 public boolean problem(int[][] grid) {
		 int m = grid.length;
	        int n = grid[0].length;

	        int[] dx = {-1,1,0,0};
	        int[] dy = {0,0,-1,1};
	        
	        boolean[][] visited = new boolean[m][n];

	        Queue<int[]> q = new LinkedList<>();
	        q.add(new int[]{0,0});
	        visited[0][0] = true;

	        while (!q.isEmpty()) {
	            int[] u = q.poll();
	            if(u[0] == m-1 && u[1] == n-1) {
	                return true;
	            }

	            for (int i=0; i<4; i++) {
	                int nu = u[0] + dx[i];
	                int nv = u[1] + dy[i];

	                if (nu >= 0 && nu<m && nv>=0 && nv<n && !visited[nu][nv] && grid[nu][nv] < grid[u[0]][u[1]]) {
	                    visited[nu][nv] = true;
	                    q.add(new int[]{nu, nv});
	                }
	            }
	        }
	        return false;
		 
	            
	    }
	 //sol2 :Solution 2 (Dijkstra)
	 public int minCostPath(int grid[][]) {
	        int m = grid.length;
	        int n = grid[0].length;

	        int[] dx = {-1,1,0,0};
	        int[] dy = {0,0,-1,1};

	        int[][] cost = new int[m][n];
	        for (int i=0; i<m; i++) Arrays.fill(cost[i], Integer.MAX_VALUE);

	        //i, j, cost
	        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
	        pq.add(new int[]{0,0,0});
	        cost[0][0]=0;

	        while (!pq.isEmpty()) {
	            int[] u = pq.poll();
	            if(u[0] == m-1 && u[1] == n-1) {
	                return cost[u[0]][u[1]];
	            }

	            for (int i=0; i<4; i++) {
	                int nu = u[0] + dx[i];
	                int nv = u[1] + dy[i];

	                if (nu >= 0 && nu<m && nv>=0 && nv<n) {
	                    int c = grid[nu][nv] < grid[u[0]][u[1]] ? 0 : grid[nu][nv] - grid[u[0]][u[1]];
	                    if (cost[nu][nv] == Integer.MAX_VALUE || cost[u[0]][u[1]] + c < cost[nu][nv]) {
	                        cost[nu][nv] = cost[u[0]][u[1]] + c;
	                        pq.add(new int[]{nu, nv, cost[nu][nv]});
	                    }
	                }
	            }
	        }
	        return Integer.MAX_VALUE;
	    }

	

	public static void main(String[] args) {
		 int[][] m1 = new int[][] { { 20, 100, 12,  11, 10 }, { 19, 100, 13, 100,  9 }, { 18, 100, 14, 100,  8 }, { 17, 16 , 15, 100,  7 } };
	        if (new canReachBottom().problem(m1) != true)
	            System.out.println("Wrong answer for #1");
	 
	        int[][] m2 = new int[][] { { 20, 100, 12,  11, 10 }, { 100, 100, 13, 100,  9 }, { 18, 100, 14, 100,  8 }, { 17, 100, 15, 100,  7 } };
	        if (new canReachBottom().problem(m2) != false)
	            System.out.println("Wrong answer for #2");    
	    }

	}


