import java.util.*;

/******************************************************************************
	 *  Compilation:  javac Permutations.java
	 *  Execution:    java Permutations n
	 *  
	 *  Enumerates all permutations on n elements.
	 *  Two different approaches are included.
	 *
	 *  % java Permutations 3
	 *  abc
	 *  acb
	 *  bac 
	 *  bca
	 *  cab
	 *  cba
	 *
	 ******************************************************************************/

	public class Permutations {
		static List<List<Character>> result=new ArrayList<List<Character>>();

	    // print n! permutation of the characters of the string s (in order)
	    public  static void perm1(String s) { perm1("", s); }
	    private static void perm1(String prefix, String s) {
	        int n = s.length();
	        if (n == 0) System.out.println(prefix);
	        else {
	            for (int i = 0; i < n; i++)
	               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
	        }

	    }

	    // print n! permutation of the elements of array a (not in order)
	    public static void perm2(String s) {
	        int n = s.length();
	        char[] a = new char[n];
	        for (int i = 0; i < n; i++)
	            a[i] = s.charAt(i);
	        perm2(a, n);
	    }

	    private static void perm2(char[] a, int n) {
	        if (n == 1) {
	        	System.out.println(new String(a));
	            return;
	        }
	        for (int i = 0; i < n; i++) {
	            swap(a, i, n-1);
	            perm2(a, n-1);
	            swap(a, i, n-1);
	        }
	    }  

	    // swap the characters at indices i and j
	    private static void swap(char[] a, int i, int j) {
	        char c = a[i];
	        a[i] = a[j];
	        a[j] = c;
	    }

//sol3 test
	   
	    public static List<List<Character>> permute(char[] nums) 
	    {
	        permute(nums, 0);
	        return result;
	    }
	   public static void permute(char[] nums, int start) 
	   {
	    for(int i = start; i < nums.length; i++){
	        char temp = nums[start];
	        nums[start] = nums[i];
	        nums[i] = temp;
	        permute(nums, start + 1);
	        nums[i] = nums[start];
	        nums[start] = temp;
	    }
	    if (start == nums.length - 1)
	    {
	        List<Character> temp=new ArrayList<Character>();
	       for( char s : nums ) 
	                  temp.add(s);
	       result.add(temp);
	    }
	}

	    public static void main(String[] args) {
	       // int n = Integer.parseInt(args[0]);
	       // String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    	int n=3;
	    	String alphabet = "abc";
	        String elements = alphabet.substring(0, n);
	     //   perm1(elements);
	        System.out.println();
	        perm2(elements);
	        System.out.println("permutation3:");
	        List<List<Character>> result1=permute(alphabet.toCharArray());
	        result1.forEach(innerList -> {
	            innerList.forEach(s-> System.out.println("Output: "+ s));
	        });
	    }
	}