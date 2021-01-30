package test;

import java.util.*;

public class interval {
	class Interval {
	    int start;
	    int end;
	    Interval(int start, int end) {
	    	this.start=start;
	    	this.end=end;
	    }
	}

	public List<Interval> mergeIntervals(List<Interval> intervals, Interval newInterval)
	{
	    int i=0;
	    List<Interval> result=new ArrayList<>();    //result
	                                                    
	    
	    while(i< intervals.size() && intervals.get(i).end< newInterval.start){
	        result.add(intervals.get(i));
	        i++;
	    }
	    while(i< intervals.size() && intervals.get(i).start<=newInterval.end){
	        newInterval.start=Math.min(newInterval.start, intervals.get(i).start);
	        newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
	        i++;
	    }
	    
	    result.add(newInterval);
	    while(i< intervals.size()){
	        result.add(intervals.get(i));
	        i++;
	    }
	    return result;
	}




























	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
