import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
		public static int[][] mergeInterval(int[][] intervals) {
	        
	        if (intervals == null || intervals.length == 0)
	           return new int[0][0];
	       
	       Arrays.sort(intervals, ((x, y) -> x[0] - y[0]));
	       List<int[]> merged = new ArrayList<>();
	       int[] current = intervals[0];
	       int count=0;
	       for (int i = 1; i < intervals.length; i++) {
	           if (current[1] >= intervals[i][0]) {
	               current[1] = Math.max(current[1], intervals[i][1]);
	               count++;
	           }
	           else {
	               merged.add(current);
	               current = intervals[i];                
	           }
	       }
	       merged.add(current);
	       System.out.println(count);
	       return merged.toArray(new int[0][0]);
	   }
		public static void main(String[] args) {
			 int[][] testIn_1 = { { 1, 3 }, { 2, 6 }, {8, 10}, {15, 18} };
		        int[][] testOut_1 = { {1, 6}, {8, 10}, {15, 18} };
		        assert Arrays.equals(mergeInterval(testIn_1), testOut_1);
		   //     System.out.println("Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].");
                
		        int[][] testIn_2 = { { 0,30 }, { 5,10 }, {15,20}};
		        mergeInterval(testIn_2);
		        
		        

		}

	}

	
