import java.util.*;

public class InsertInterval57 {
	 public static int[][] insert(int[][] intervals, int[] newInterval) {
		 List<int[]> result = new ArrayList<>();
		int i=0;
		 while(i<intervals.length && intervals[i][1]<newInterval[0]) {
			 result.add(intervals[i++]);
		 }
		 while(i < intervals.length && intervals[i][0] <= newInterval[1]){
	            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
	            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
	            i++;
	        }
		 result.add(newInterval);
		 
		 while(i < intervals.length) result.add(intervals[i++]);
	        
	        return result.toArray(new int[result.size()][]);
		 
	 }

	public static void main(String[] args) {
		int[][] intervals = {{1,3},{6,9}};
		int[] newInterval = {2,5};
		int[][] result=insert(intervals,newInterval);//Output: [[1,5],[6,9]]
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				System.out.println(result[i][j]);
			}
			System.out.println(" ");
		}
				

	}

}
