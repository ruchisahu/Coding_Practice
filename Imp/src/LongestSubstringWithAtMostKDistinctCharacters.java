/*
Leetcode 340: Longest Substring with At Most K Distinct Characters
Given a string, find the length of the longest substring T that contains at most k distinct characters.
Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.

用sliding window 去做，把出现的字符都存到map里，如果map的size大于k，就说明出现了大于k的字符，
删除start的字符，移动start，直道map的size小于或等于k
 */

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        if(s == null || s.length() == 0) return 0;

        HashMap<Character,Integer> map = new HashMap<>();
        int res = 0, start = 0;

        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);

            map.put(c, map.getOrDefault(c,0) + 1);
            while(map.size() > k){
                char x = s.charAt(start);
                map.put(x, map.get(x) - 1);
                if(map.get(x) == 0){
                    map.remove(x);
                }
                start++;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String args[]){
        String s = "aabb";
        int k = 3;

        System.out.println(lengthOfLongestSubstringKDistinct(s,k));
    }

}
