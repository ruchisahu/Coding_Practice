import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/
public class KClosetPoints973 {

	public static int[][] kClosest(int[][] points, int K) {
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
	    for (int[] p : points) {
	        pq.offer(p);
	        if (pq.size() > K) {
	            pq.poll();
	        }
	    }
	    int[][] res = new int[K][2];
	    while (K > 0) {
	        res[--K] = pq.poll();
	        System.out.println(res[K][0]+"  "+res[K][1]);
	       
	    }
	   
	    return res;
	}

	public static void main(String[] args) {
		int K=2;
		int[][] points= {{3,3},{5,-1},{-2,4}};
		kClosest(points,K);

	}                                            

}
                                                                                                                                                                                                                                                                                                                                