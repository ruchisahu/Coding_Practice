import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        HashSet<String> wordList = new HashSet<>(wordDict);
        HashMap<String,List<String>> map = new HashMap<>();

        return helper(s, wordList, map);
    }

    public static List<String> helper(String s, HashSet<String> wordList, HashMap<String,List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }

        if(s.length()== 0) return null;
        List<String> ans = new ArrayList<>();

        for(int i = 1; i < s.length(); i++){
            String subStr = s.substring(0,i);

            if(wordList.contains(subStr)){
                List<String> subAns = helper(s.substring(i), wordList, map);

                if(subAns == null){
                    ans.add(subStr);
                }else{
                    for(String str : subAns){
                        ans.add(subStr + " " + str);
                    }
                }
            }
        }
        map.put(s,ans);
        return ans;
    }

    public static void main(String args[]){
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        String[] arr = new String[]{"cat", "cats", "and", "sand", "dog"};
        for(String x : arr){
            list.add(x);
        }

        System.out.println(wordBreak(s,list));
    }
}
