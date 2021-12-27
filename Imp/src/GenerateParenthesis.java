import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        if(n <= 0) return res;
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, res, sb);
        return res;
    }

    public static void dfs(int n, int open, int close, List<String> res, StringBuilder sb){
        if(sb.length() == n*2){
            res.add(sb.toString());
            return;
        }

        if(open < n){
            sb.append('(');
            dfs(n,open + 1, close, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open){
            sb.append(')');
            dfs(n,open, close + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String args[]){
        System.out.println(generateParenthesis(3));
    }
}
