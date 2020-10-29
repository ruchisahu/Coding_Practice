import java.util.*;

public class MergeInterval {
	public int[][] merge(int[][] intervals) {
        
        if (intervals == null || intervals.length == 0)
           return new int[0][0];
       
       Arrays.sort(intervals, ((x, y) -> x[0] - y[0]));
       List<int[]> merged = new ArrayList<>();
       int[] current = intervals[0];
       for (int i = 1; i < intervals.length; i++) {
           if (current[1] >= intervals[i][0])
               current[1] = Math.max(current[1], intervals[i][1]);
           else {
               merged.add(current);
               current = intervals[i];                
           }
       }
       merged.add(current);
       return merged.toArray(new int[0][0]);
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
