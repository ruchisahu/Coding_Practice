/*
You are given two strings s1 and s2 of equal length consisting of letters "x" and "y" only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap s1[i] and s2[j].
Return the minimum number of swaps required to make s1 and s2 equal, or return -1 if it is impossible to do so.
 
Example 1:
Input: s1 = "xx", s2 = "yy"
Output: 1
Explanation: 
Swap s1[0] and s2[1], s1 = "yx", s2 = "yx".
Example 2: 
Input: s1 = "xy", s2 = "yx"
Output: 2
Explanation: 
Swap s1[0] and s2[0], s1 = "yy", s2 = "xx".
Swap s1[0] and s2[1], s1 = "xy", s2 = "xy".
Note that you can't swap s1[0] and s1[1] to make s1 equal to "yx", cause we can only swap chars in different strings.
 */
public class MinimumSwap {
	
	 public static int minimumSwap(String s1, String s2)
	    {
		 int len1=s1.length();
		 int len2=s2.length();
		 int x1=0,x2=0,y1=0,y2=0;
		 if(len1!=len2)return -1;
		 for(int i=0;i<len1;i++)
		 {
			 if(s1.charAt(i)==s2.charAt(i))
				 continue;
			 else if(s1.charAt(i)=='x' && s2.charAt(i)=='y') {
				 x1++;
				 y2++;
			 }
			 else
				 x2++;
			 y2++;
		 
			
		 }
		 
		 int count=(y1/2)+(x1/2); // tried to get all the '1-swap pairs'; Just take two pairs from each
	        x1=x1%2;
	        y1=y1%2;
	        
	        if(x1!=y1) // If in the remaining pairs we can get all of them to be '2-swap pairs' then -1;
	            return -1;
	        count+=x1*2; // Add 2 per pair left ;
	        
	        return count;
	    }

	public static void main(String[] args) {
		String s1="xx";
		String s2="yy";
		System.out.println(minimumSwap(s1, s2));
		

	}

}
