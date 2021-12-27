import java.util.*;
import java.lang.*;


public class MeetingRooms1 {
    public static boolean canAttend(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;


        // lambda way
        //Arrays.sort(intervals,(Interval i1, Interval i2) -> (i1.start - i2.start));

        // by implements comparator<Interval> -- see sortMethod class
        //Arrays.sort(intervals,new sortMethod());

        /* classic way to do comparator
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare (Interval o1, Interval o2) {
                if(o1.start == o2.start){
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });
        */
/*
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i-1].end){
                return false;
            }
        }
        return true;
    }
*/
        //create two arrays to store start times and ends time from intervals
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < start.length; i++) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        // sort start and end arrays
        Arrays.sort(start);
        Arrays.sort(end);

        // compare if the 2nd start time is smaller than the ist end time then we know the person can not attend the two meetings.
        for(int i = 1; i < start.length; i++){
            if(start[i] < end[i-1]){
                return false;
            }
        }
        return true;

    }

    public static void main(String args[]){
        Interval[] arr = new Interval[2];
        arr[0] = new Interval(7,10);
        arr[1] = new Interval(2,4);
        //arr[2] = new Interval(15,20);

        boolean res = canAttend(arr);
        System.out.println(res);
    }


}
