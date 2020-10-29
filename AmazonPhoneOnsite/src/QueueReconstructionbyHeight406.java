import java.util.*;

/*
 * Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionbyHeight406 {
	 public static int[][] reconstructQueue(int[][] people) {
	        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
	        for(int i=0;i<people.length;i++) {
	        	System.out.println(people[i][0]+"   "+people[i][1]);
	        	
	        }
	        List<int[]> res = new ArrayList<>();
	        for(int[] p : people){
	        	System.out.println(p[1] +"  "+p[0]);
	            res.add(p[1], p);
	        }
	        System.out.println("...................");
	        for(int i=0;i<res.size();i++) {
	        	System.out.println(res.get(i)[0]+"   "+res.get(i)[1]);
	        }
	        int n = people.length;
	        return res.toArray(new int[n][2]);
	    }
	public static void main(String[] args) {
		int[][]p= {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		reconstructQueue(p);
		// TODO Auto-generated method stub

	}

}
