import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Given n ropes of different lengths, we need to connect these ropes into one rope. 
 * We can connect only 2 ropes at a time. 
 * The cost required to connect 2 ropes is equal to sum of their lengths. 
 * The length of this connected rope is also equal to the sum of their lengths. 
 * This process is repeated until n ropes are connected into a single rope. 
 * Find the min possible cost required to connect all ropes.
 * */
 
public class MinCostRope 
{
static int MinCost(int[] len)
{
	
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(); 
	for (int i = 0; i < len.length; i++) { 
        pq.add(len[i]); 
    } 
	    int totalCost = 0;
	    while (pq.size() > 1) {
	        int cost = pq.poll() + pq.poll();
	        pq.add(cost);
	        totalCost += cost;
	    }
	    return totalCost;
	}
	public static void main(String[] args) 
	{
		int[] len = {8, 4, 6, 12};
		System.out.println(MinCost(len));
	}

}
