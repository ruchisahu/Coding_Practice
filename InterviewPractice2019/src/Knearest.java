import java.util.Comparator;
import java.util.PriorityQueue;

public class Knearest
{
	 public static int[][] kClosest(int[][] points, int K) 
	 {
	       PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));
	        for (int[] p : points) { 
	            pq.offer(p); 
	            if (pq.size() > K) 
	            {
	                pq.poll(); 
	            } 
	        }
	        int[][] ans = new int[K][2];
	        while (K-- > 0)
	        { 
	        	ans[K] = pq.poll(); 
	        	
	        }
	        System.out.println(ans[0][0]);
	        return ans;
	       
	    }
	
	public static void main(String[] args) 
	{
		//post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
		int[][] post_offices= {{-16,5},{-1,2},{4,3},{10,-2}};
				int k = 3;
				System.out.println(kClosest(post_offices, k));

	}

}
