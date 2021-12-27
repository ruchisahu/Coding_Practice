import java.util.Arrays;

public class MeetingRooms2 {

    public static int requirtedRooms(Interval[] intervals){
        if(intervals == null || intervals.length == 0) return 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0; i < start.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count = 0;
        int endpoint = 0;

        /* if start time is smaller than end time means we need a new meeting room,
           end pointer doesn't move. we have to see how many start times that begin
            before end pointer.
            Otherwise we move end pointer to next end time but we dont need to plus one
            meeting room because one meeting is already finished so no need to add one more room
        */
        for(int i = 0; i < start.length; i++){
            if(start[i] < end[endpoint]){
                count++;
            }else{
                endpoint++;
            }
        }

        return count;
    }

    public static void main(String args[]){
        Interval[] arr = new Interval[3];
        arr[0] = new Interval(0,30);
        arr[1] = new Interval(5,10);
        arr[2] = new Interval(15,20);

        int res = requirtedRooms(arr);
        System.out.println(res);
    }
}
