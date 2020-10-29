import java.util.Scanner;

public class Anagram
{
	 static boolean isAnagram(String s, String t) 
	    {
	        // Complete the function
	         int[] alphabet = new int[26];
	        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
	        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
	         for (int i : alphabet)
	              if (i != 0)
	                 return false;
	          
	                
	               return true;
	         
	          
	    }

	  public static void main(String[] args) 
	  {
	    
	        Scanner scan = new Scanner(System.in);
	        String a = scan.next();
	        String b = scan.next();
	        scan.close();
	        boolean ret = isAnagram(a, b);
	        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	    }
	}


