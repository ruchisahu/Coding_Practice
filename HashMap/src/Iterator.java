import java.util.HashMap;
import java.util.Map;

public class Iterator {
	 Map<String, Integer> map = new HashMap<>();

	public String Min() {
	 int val = Integer.MIN_VALUE;
     String str = "";
     for (Map.Entry<String, Integer> obj : map.entrySet()) {
         if (obj.getValue() > val) {
             str = obj.getKey();
             val = obj.getValue();
         }
     }
     return str;

}
}
