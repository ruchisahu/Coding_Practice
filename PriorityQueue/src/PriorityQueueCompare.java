import java.util.PriorityQueue;

public class PriorityQueueCompare {
	 public static int[][] kClosest(int[][] points, int k) {
			int[][] ans=new int[k][2];
			PriorityQueue<int[]>pq=new PriorityQueue<int[]>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
			for(int[]point:points) {
				pq.add(point);
			}
			while(k-->0) {
				ans[k]=pq.poll();
			}
			return ans;
		}

	public static void main(String[] args) {
		int[][] points= {{1,3},{-2,2}};
		int K = 1;
		kClosest(points,K);

	}

}
