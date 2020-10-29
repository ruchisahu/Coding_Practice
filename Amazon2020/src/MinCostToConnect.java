/*
 * https://leetcode.com/problems/minimum-cost-to-connect-sticks (premium)


Given n ropes of different lengths, we need to connect these ropes into one rope. 
We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. 
The length of this connected rope is also equal to the sum of their lengths. 
This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.
 * */
import java.util.*;

public class MinCostToConnect 
{

	public static void main(String[] args
			) {
		int[] files1 = {8, 4, 6, 12};
		int[] files2 = {20, 4, 8, 2};
		int[] files3 = {1, 2, 5, 10, 35, 89};
		int[] files4 = {2, 2, 3, 3};
		System.out.println(mergeFiles(files1));
		System.out.println(mergeFiles(files2));
		System.out.println(mergeFiles(files3));
		//System.out.println(mergeFiles(files4));

	}

	private static int mergeFiles(int[] r) {
		
		int cost=0;
		int totalcost=0;
		int j=r.length;
		//System.out.println("j=  "+j);
		
		while(j>1)
		{
				Arrays.sort(r,0,j);
			
				cost=r[0]+r[1];
				totalcost=totalcost+cost;
				
			//	System.out.println("cost"+cost);
				r[0]=cost;
				
				
				for(int i=1;i<j-1;i++)
				{
					
					r[i]=r[i+1];
				}
				
				
				j--;
		}
		
		return totalcost;
	}
	
	//sol2 priority queue
	private static int mergeFiles1(int[] files) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int f : files) {
			minHeap.offer(f);
		}
		int res = 0;
		while(minHeap.size() > 1) {
			int f1 = minHeap.poll();
			int f2 = minHeap.poll();
			int tmp = f1 + f2;
			res += tmp;
			minHeap.offer(tmp);
		}
		return res;
	}
	
	//sol3
	public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int rope: ropes) pQueue.add(rope);
        int cost = 0;
        while(pQueue.size() !=1) {
            //System.out.println(Arrays.toString(pQueue.toArray()));
            int temp = pQueue.poll() + pQueue.poll();
            cost += temp;
            pQueue.add(temp);
        }
        return cost;
    }
	
	//sol4
	public static int minCost(List<Integer> ropes) {

	    Queue<Integer> pq = new PriorityQueue<>(ropes);

	    int totalCost = 0;

	    while (pq.size() > 1) {

	        int cost = pq.poll() + pq.poll();

	        pq.add(cost);

	        totalCost += cost;

	    }

	    return totalCost;

	}   

}
