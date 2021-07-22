import java.util.TreeMap;
//Time Complexity: O(N^2)O(N 


public class MyCalendar3_732 {
	TreeMap<Integer, Integer> delta;

    public MyCalendar3_732() {
        delta = new TreeMap();
    }

    public int book(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int active = 0, ans = 0;
        for (int d: delta.values()) {
            active += d;
            if (active > ans) ans = active;
        }
        return ans;
    }

	public static void main(String[] args) {
		MyCalendar3_732 cal=new MyCalendar3_732();
		System.out.println(cal.book(10,20));
		System.out.println(cal.book(50,60));
		System.out.println(cal.book(10,40));
		System.out.println(cal.book(5,15));
		System.out.println(cal.book(5,10));
		System.out.println(cal.book(25,55));

	}

}
