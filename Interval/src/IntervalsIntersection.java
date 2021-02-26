import java.util.*;
//https://leetcode.com/problems/interval-list-intersections/submissions/
public class IntervalsIntersection {
    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
	        List<Interval> intervalsIntersection = new ArrayList<Interval>();
	        // TODO: Write your code here
	        int i = 0, j = 0;
	        while (i < arr1.length && j < arr2.length) {
	            if ((arr1[i].start <= arr2[j].start && arr2[j].start <= arr1[i].end) ||
	                (arr2[j].start <= arr1[i].start && arr1[i].start <= arr2[j].end)) {
	                intervalsIntersection.add(new Interval(Math.max(arr1[i].start, arr2[j].start), Math.min(arr1[i].end, arr2[j].end)));
	            }
	            if (arr1[i].end < arr2[j].end) i++;
	            else j++;
	        }
	        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
	    }
    
    //array
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        
        List<int[]> intervalsIntersection = new ArrayList();
        // TODO: Write your code here
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i][0] <= arr2[j][0] && arr2[j][0] <= arr1[i][1]) ||
                (arr2[j][0] <= arr1[i][0] && arr1[i][0] <= arr2[j][1])) {
                intervalsIntersection.add(new int[]{Math.max(arr1[i][0], arr2[j][0]), Math.min(arr1[i][1], arr2[j][1])});
            }
            if (arr1[i][1] < arr2[j][1]) i++;
            else j++;
        }
        return intervalsIntersection.toArray(new int[intervalsIntersection.size()][]);
    }

	    public static void main(String[] args) {
	        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
	        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
	        Interval[] result = IntervalsIntersection.merge(input1, input2);
	        System.out.print("Intervals Intersection: ");
	        for (Interval interval : result)
	            System.out.print("[" + interval.start + "," + interval.end + "] ");
	        System.out.println();

	        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
	        input2 = new Interval[] { new Interval(5, 10) };
	        result = IntervalsIntersection.merge(input1, input2);
	        System.out.print("Intervals Intersection: ");
	        for (Interval interval : result)
	            System.out.print("[" + interval.start + "," + interval.end + "] ");
	    }
	}
	