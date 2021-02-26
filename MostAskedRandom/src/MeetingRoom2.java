import java.util.*;

public class MeetingRoom2 {
public static void main(String[] args) {
		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		System.out.println("Min no of meeting rooms required is " + findMinNoOfMeetingRooms(intervals));

	}

	public static int findMinNoOfMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int count = 1;
		queue.offer(intervals[0].end);
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < queue.peek()) {
				count++;
			} else {
				queue.poll();
			}
			queue.offer(intervals[i].end);
		}

		return count;
	}

	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}