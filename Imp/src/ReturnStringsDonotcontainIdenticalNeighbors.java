import java.util.ArrayList;
import java.util.List;

public class ReturnStringsDonotcontainIdenticalNeighbors {
    public static List<String> returnString(int k, int n){
        List<String> res = new ArrayList<>();
        if(k == 0 || n == 0) return res;
        String word = "abc";

        helper(res, k, n, new StringBuilder(), word);

        return res;

    }

    public static void helper(List<String> res, int k, int n, StringBuilder sb ,String word){
        if(res.size() == k){
            return;
        }

        if(sb.length() == n){
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i < word.length(); i++){
            if(sb.length() == 0 || sb.charAt(sb.length() - 1) != word.charAt(i)){
                sb.append(word.charAt(i));
                helper(res, k, n, sb, word);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String args[]){
        List<String> res = returnString(4,2);
        System.out.println(res);
    }
}
