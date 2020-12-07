/*
 * a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]
...................................
nput:
a = [[1, 3], [2, 5], [3, 7], [4, 10]]
b = [[1, 2], [2, 3], [3, 4], [4, 5]]
target = 10

Output: [[2, 4], [3, 2]]
 */
package test;

import java.util.ArrayList;
import java.util.List;

public class OptimalUtilization
{
	private static List<List<Integer>> compute(int[][] a, int[][] b, int target) {
		List<List<Integer>>result=new ArrayList<List<Integer>>();
		int diff = Integer.MAX_VALUE;
		int max=0;
		for(int[] a1:a) {
			int a3=a1[1];
			for(int[] b1:b) {
				
				int b3=b1[1];
				int sum=a3+b3;
				
				if(sum<=target) {
					List<Integer>temp=new ArrayList<Integer>();
					if(sum-target<diff) {
						result.clear();
						//List<Integer>temp=new ArrayList<Integer>();
						temp.add(a1[0]);
						temp.add(b1[0]);
						result.add(temp);
					}
					else if(sum-target==diff) {
						//List<Integer>temp=new ArrayList<Integer>();
						temp.add(a1[0]);
						temp.add(b1[0]);
						result.add(temp);
					}
					
				}
				
			}
		}
		return result;
		
	}
		
	

	   public static void main(String...s) {
	        int[][][] As = {
	            {{1, 2}, {2, 4}, {3, 6}},
	            {{1, 3}, {2, 5}, {3, 7}, {4, 10}},
	            {{1, 8}, {2, 7}, {3, 14}},
	            {{1, 8}, {2, 15}, {3, 9}}
	        };
	        int[][][] Bs = {
	            {{1, 2}},
	            {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
	            {{1, 5}, {2, 10}, {3, 14}},
	            {{1, 8}, {2, 11}, {3, 12}}
	        };
	        int[] targets = {7, 10, 20, 20};

	        for (int i=0; i<4; i++) {
	            System.out.println("target sum  "+targets[i]+" :  "+compute(As[i], Bs[i], targets[i]).toString());
	        }

}
}
