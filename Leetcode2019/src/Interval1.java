import java.util.*;
import java.util.List;

public class Interval1 
{
	 
	      
	    	public static ArrayList<Interval> merge(List<Interval> intervals)
	    	{
	            ArrayList<Interval> result = new ArrayList<Interval>();
	            if (intervals == null || intervals.size() == 0) {
	                return result;
	            }
	             
	            Collections.sort(intervals,new Comparator<Interval>() {
	                @Override
	                public int compare(Interval i1, Interval i2) {
	                    return Integer.compare(i1.start, i2.start);
	                }
	            });
	             
	            Interval prev = intervals.get(0);
	            for (int i = 1; i < intervals.size(); i++) {
	                Interval curr = intervals.get(i);
	                if (isOverlapped(curr, prev)) {
	                    prev.start = prev.start;
	                    prev.end = Math.max(curr.end, prev.end);
	                } else {
	                    result.add(prev);
	                    prev = curr;
	                }
	            }
	             
	            result.add(prev);
	            return result;
	        }
	         
	        private static boolean isOverlapped(Interval curr, Interval prev) {
	            return curr.start <= prev.end;
	        }
	         
	     /*   private class IntervalComparator implements Comparator<Interval> {
	            public int compare(Interval a, Interval b) {
	                return a.start - b.start;
	            }
	        }
	    */
	
	public static void main(String[] args) 
	{
		List<Interval> intervals=new ArrayList<Interval>();
		
		merge(intervals);

	}

}
