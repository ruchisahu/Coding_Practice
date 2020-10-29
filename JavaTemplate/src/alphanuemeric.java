
public class alphanuemeric {
    public boolean isPalindrome(String s) 
    {
         int i = 0;
        int j = s.length()-1;
        s = s.toLowerCase();
        while (i < j){
            while (i < j && !isValidChar(s.charAt(i))) i++;
            while (i < j && !isValidChar(s.charAt(j))) j--;
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
   static  boolean isValidChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}


