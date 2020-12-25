import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Earliest time to complete deliveries : - @Sithis

A geographic node has multiple Amazon buildings, each with 4 receiving docks. The number of intake deliveries is equal to the total number of receiving docks in the node. Each intake delivery has a predicted offloading time, and each building has a specified time when its receiving docks become available for intake. Assuming that exactly 4 deliveries are assigned to each building and that those deliveries run independently (asynchronously) on the receiving docks of the chosen building, what is the earliest time that all intake deliveries can be completed?
Write an algorithm to find the earliest time that all intake deliveries can be completed.

Input
The input to the function/method consists of three arguments:
numOfBuildings, an integer representing the number of buildings;
buildingopenTime, a list of integers representing the times at which all 4 docks of the ith building become available;
offloadTime, a list of integers representing the offload time of each intake delivery.

Output
Return an integer representing the earliest time at which all the intake deliveries can be offloaded.

Note
The length of offloadTime is 4* numOfBuildings.

Constraints
1 <= numOfBuildings <= 10^5
1 <= buildingopenTime[i] < 10^6
1 <= offloadTime[j] <= 10^6
0 <= i<numOfBuildings
0 <= j < 4 * numOfBuildings

Example
Input:
numOfBuildings = 2
buildingopenTime = [8, 10]
offloadTime = [2,2,3,1,8,7,4,5]

Output:
16

Explanation:
One optimal solution is as follows:
Assign the intake deliveries with the offload times 2, 3, 7, and 8 to building O that opens at time 8.
Assign the intake deliveries with the offload times 4, 2, 5, and 1 to building 1 that opens at time 10.
The first building's intake deliveries finish at times (8+2), (8+3), (8+7), and (8+8), which are 10, 11, 15, and 16 respectively.
The second building's intake deliveries finish at times (10+4), (10+2), (10+5), and (10+1), which are 14, 12, 15, and 11 respectively.
The maximum among those finishing times is 16. This is the earliest possible finish time.
 
 *Probably not the most optimal but

Use minHeap to store earliest available docks (intialize with 4* each building open time)
sort the offloading times
iterate through offloading times
add the largest offloading time to the earliest available dock which would be the first element of the minHeap then add this sum to the minHeap
keep track of the largest sum and return that at the end of the loop
Time: O(m*nlog(n)), Space: O(n) : n is numOfBuildings and m size of offloadTimes
https://leetcode.com/playground/FGYEbSjC
 *
 */
public class Complete_Delivery {


	    public static void main(String[] args) {
	        int[] b1 = new int[]{8,10};
	        int[] o1 = new int[]{2,2,3,1,8,7,4,5};
	        
	        int[] b2 = new int[]{1,10};
	        int[] o2 = new int[]{3,1};
	        
	        int[] b3 = new int[]{9,15,100};
	        
	        
	        System.out.println(offloadDeliveries(2, b1, o1) == 16);
	        System.out.println(offloadDeliveries(2, b2, o2) == 4);
	        System.out.println(offloadDeliveries(3, b3, o1) == 17);
	    }
	    
	    public static int offloadDeliveries(int numofBuildings, int[] buildingOpenTimes, int[] offloadTimes) {
	        if (buildingOpenTimes.length == 0 && offloadTimes.length > 0) return -1;
	        if (offloadTimes.length == 0) return 0;
	        
	        PriorityQueue<Integer> availableStartTimes = new PriorityQueue<Integer>();
	        for (int openTime : buildingOpenTimes) {
	            for (int i = 0; i < 4; i++) {
	                availableStartTimes.add(openTime);
	            }
	        }
	        
	        Arrays.sort(offloadTimes);
	        int max = 0;
	        for (int i = offloadTimes.length-1; i >= 0; i--) {
	            int finishTime = availableStartTimes.poll() + offloadTimes[i];
	            availableStartTimes.add(finishTime);
	            max = Math.max(max, finishTime);
	        }
	        
	        return max;
	    }
	}
