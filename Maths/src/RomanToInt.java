import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
	 public static int romanToInt(String s) {
	if (s == null || s.length() == 0) {
        return 0;
    }

    Map<Character, Integer> map = new HashMap<>();
    map.put('M', 1000);
    map.put('D', 500);
    map.put('C', 100);
    map.put('L', 50);
    map.put('X', 10);
    map.put('V', 5);
    map.put('I', 1);

    int sum = 0;
    int prev = map.get(s.charAt(0));
    int next = 0;

    for (int i = 1; i < s.length(); i++) {
        next = map.get(s.charAt(i));

        if (prev < next) {
            sum -= prev;
        } else {
            sum += prev;
        }

       prev = next;
    }

    sum += prev;
    return sum;
    
}


	public static void main(String[] args) {
		String s = "LVIII";     //58
		System.out.println(romanToInt(s));

	}

}
