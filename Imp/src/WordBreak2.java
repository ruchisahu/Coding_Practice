import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak2 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if(s == null || wordDict == null) return res;

        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String,List<String>> map = new HashMap<>();

        res = helper(s,set,map);
        return res;
    }

    public static List<String> helper(String s, HashSet<String> set, HashMap<String,List<String>> map){
        if(map.containsKey(s)) return map.get(s);

        if(s.length() == 0) return null;
        List<String> res = new ArrayList<>();

        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0,i);
            System.out.println("sub:" + sub);
            List<String> partres = null;
            if(set.contains(sub)){
                partres = helper(s.substring(i),set,map);
                System.out.println("partres:" + partres);
                if(partres == null){
                    res.add(sub);
                }else{
                    for(String str : partres){
                        System.out.println("forsub:" + sub);
                        System.out.println("forstr:" + str);
                        res.add(sub + " " + str);
                        System.out.println("forloopres:" + res);
                    }
                }
            }
        }

        map.put(s,res);
        System.out.println("res1:" + res);
        return res;
    }

    public static void main(String args[]){
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        wordDict.add("cats");

        List<String> temp = new ArrayList<>();
        temp = wordBreak(s,wordDict);

        System.out.println("res:" + temp);
    }
}
