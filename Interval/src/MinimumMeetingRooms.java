import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class MinimumMeetingRooms {

    public static int findMinimumMeetingRooms(List<Interval> intervals) {
        // TODO: Write your code here
        if (intervals.size() <= 1) return intervals.size();
        int max = 1;
        Collections.sort(intervals, (a, b) -> {return a.start == b.start ? a.end-b.end : a.start-b.start;});
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals.get(0).end);
        for (int i = 1; i < intervals.size()-1; i++) {
            if (intervals.get(i).start >= queue.peek()) {
                queue.poll();
            }
            queue.add(intervals.get(i).end);
        }

        return queue.size();
    }

    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<Interval>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(1, 4));
                add(new Interval(2, 5));
                add(new Interval(7, 9));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(6, 7));
                add(new Interval(2, 4));
                add(new Interval(8, 12));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(1, 4));
                add(new Interval(2, 3));
                add(new Interval(3, 6));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

        input = new ArrayList<Interval>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);
    }
}