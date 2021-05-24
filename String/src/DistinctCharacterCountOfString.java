import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//https://howtodoinjava.com/java8/java-stream-distinct-examples/
public class DistinctCharacterCountOfString {
	public static void main(String[] args) {
	  String string = "This is One Compiler Platform.";
		Map<Character, Integer> charCountMap = new HashMap<>();
		
		//Using For loop
        for (char c : string.toCharArray()) {
            if(charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        System.out.println(charCountMap);

        charCountMap.clear();
        //Using Streams Java 8
        List<Character> list = string.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println("List of characters" +list);
        list.stream().forEach(c -> charCountMap.merge(c, 1, Integer::sum));

        System.out.println(charCountMap);
	}
}