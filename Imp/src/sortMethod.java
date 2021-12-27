import java.util.Comparator;

public class sortMethod implements Comparator<Interval> {
    public int compare(Interval a, Interval b){
        if(a.start == b.start) {
            return a.end - b.end;
        }

        return a.start - b.start;
    }
}
