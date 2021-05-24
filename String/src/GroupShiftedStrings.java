/*
Leetcode 249 Group Shifted Strings
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public static List<List<String>> groupStrings(String[] strings) {
        List<List<String>> groups = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            String encoded = encode(s);
            if (!map.containsKey(encoded)) {
                map.put(encoded, new ArrayList<>());
            }
            map.get(encoded).add(s);
        }

        for (String key : map.keySet()) {
            groups.add(map.get(key));
        }
        return groups;
    }

    private static String encode(String s) {
        if (s.length() == 1) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append((s.charAt(i) + 26 - s.charAt(i - 1)) %26);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String[] arr = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        System.out.println(groupStrings(arr));
    }
}
