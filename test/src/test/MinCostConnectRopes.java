package test;

import java.util.PriorityQueue;

public class MinCostConnectRopes {
	public static int minCost(int[] ropes) {
		int cost=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int r:ropes) {
			pq.add(r);
		}
		while(pq.size()>1) {
			int sum=pq.poll()+pq.poll();
			cost=cost+sum;
			pq.add(sum);
			
		}
		return cost;
	}

	public static void main(String[] args) {
		int[] ropes = {1, 2, 5, 10, 35, 89};   //224
		System.out.println(minCost(ropes));
	}

}
