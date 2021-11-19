import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> times = new ArrayList<>();
        for (List<Interval> list: schedule) {
            times.addAll(list);
        }
        Collections.sort(times, ((i1, i2)->i1.start-i2.start));
        Interval pre = times.get(0);
        for (int i = 1; i < times.size(); i++) {
            Interval cur = times.get(i);
            if (cur.start <= pre.end) {
                pre.end = cur.end > pre.end ? cur.end : pre.end;
            } else {
                res.add(new Interval(pre.end, cur.start));
                pre = cur;
            }    
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
