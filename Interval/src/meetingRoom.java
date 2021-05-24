import java.util.Arrays;

public class meetingRoom {
	public static boolean canAttendMeetings(Interval[] intervals) {
	    // Sort the intervals by start time
		Arrays.sort(intervals, (x, y) -> x.start - y.start);
		Interval curr=intervals[0];
		
	    for (int i = 1; i < intervals.length; i++) {
	        if (curr.end > intervals[i].start) return false;
	        curr=intervals[i];
	    }
	    return true;
	}

	public static void main(String[] args) {
		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        
		System.out.println(canAttendMeetings(input1));
	}

}
