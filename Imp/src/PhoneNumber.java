import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneNumber {
    public static List<String> letterCombinations(String numbers){
        List<String> res = new ArrayList<>();
        if(numbers == null || numbers.length() == 0) return res;

        HashMap<Character,char[]> map = new HashMap<>();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        helper(numbers,map,res,new StringBuilder(),0);
        return res;
    }

    public static void helper(String numbers, HashMap<Character,char[]> map, List<String> res, StringBuilder sb, int index){
        if(index == numbers.length()){
            res.add(sb.toString());
            return;
        }

        char c = numbers.charAt(index);
        char[] arr = map.get(c);

        for(char x : arr){
            sb.append(x);
            helper(numbers,map,res,sb,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String args[]){
        String number = "23";
        List<String> res = letterCombinations(number);
        System.out.println(res);
    }

}
