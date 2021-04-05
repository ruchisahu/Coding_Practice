import java.util.HashMap;

//https://leetcode.com/discuss/interview-question/1022745/Google-or-Software-Engineer-L3
/*
 * You have given HashMap with keys and its values
Hashmap
user - Alex.
city - Seattle.
month - September

substitute the variable of the string, and the variable in the string starts and end with character #.

String find = "mynameis#user#livesin#city#month".

String substituteString(String find) {
}

o/p would be of the above string find - mynameisAlexlivesinSeattlemonth
 */
 
public class SubstituteString_HashMap {
	public static String string_sub(HashMap<String, String> map, String s) {

		StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
        	System.out.println(sb);
            char c = s.charAt(i);
            if(c == '#') {
                int j = s.indexOf("#", i);
                System.out.println("word"+s.substring(i, j+1));
                sb.append(map.getOrDefault(s.substring(i, j+1), "?"));
                i=j;
            }
            else sb.append(c);
        }
        return sb.toString();
	}

	public static void main(String[] args) {
		HashMap<String, String>map=new HashMap<>();
		map.put("user", "Alex");
		map.put("city", "Seattle");
		map.put("month", "September");
		String s="#mynameis#user#livesin#city#month";
		System.out.println(string_sub(map,s));

	}

}
