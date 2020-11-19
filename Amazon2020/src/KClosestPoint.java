/*
 * K Nearest Post Offices
Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
Euclidean distance is applied to find the distance between you and a post office.
Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
K is a positive integer much smaller than the given number of post offices. from aonecode.com

e.g.
Input
you: [0, 0]
post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
k = 3

Output from aonecode.com
[[-1, 2], [0, 3], [4, 3]]
 */
import java.util.*;
public class KClosestPoint 
{
	public static int[][] kClosest(int[][] points, int K)
	{
	       PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[0] * a[0] - a[1] * a[1]));
	        for (int[] p : points) { 
	            pq.offer(p); 
	            if (pq.size() > K) { pq.poll(); } // poll out the farthest among the K + 1 points.
	        }
	        int[][] ans = new int[K][2];
	        while (K-- > 0)
	        {
	        	ans[K] = pq.poll();
	        	System.out.println(ans[K][0]+"  "+ans[K][1]);
	        }
	        
	        return ans;
}
	
	//sol2
	  public static int[][] kClosest1(int[][] points, int K) {

	        Arrays.sort(points, (point1,point2) -> (point1[0]*point1[0] + point1[1]*point1[1]) - (point2[0]*point2[0] + point2[1]*point2[1])); 

	        int[][] ans = new int[K][2];

	        while(K>0){

	            ans[--K]=points[K];

	        

	        }

	        

	        return ans;

	    }

	public static void main(String[] args) {
		
		int[][] points = {{1,3},{-2,2}};
				int K = 1;
				System.out.println(kClosest(points, K));
				
				int[][] points1= {{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
			//	System.out.println(kClosest(points1, K));
		

	}

}
