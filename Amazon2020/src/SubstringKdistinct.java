import java.util.*;

/*
 Given a string s and an int k, return an int representing the number of substrings (not unique) of s with exactly k distinct characters. If the given string doesn't have k distinct characters, return 0.
https://leetcode.com/problems/subarrays-with-k-different-integers

Example 1:

Input: s = "pqpqs", k = 2
Output: 7
Explanation: ["pq", "pqp", "pqpq", "qp", "qpq", "pq", "qs"]

 */
public class SubstringKdistinct {
	public static int substringsWithKDistinctChars(String s, int k)
	{
		List<String> count=new ArrayList<String>();
		int len=s.length();
		int c=0;
		
		for(int i=0;i<len-1;i++)
		{
			for(int j=i;j<len;j++)
			{
				String str=s.substring(i,j+1);
				if(str.length()>=k && unique(str))
				{
					System.out.println(str);
					count.add(str);
					c++;
				}
			}
		}
	  return c;
	}

	private static boolean unique(String str) {
		HashSet<Character> count=new HashSet<Character>();
		for(int i=0;i<str.length();i++)
		{
			count.add(str.charAt(i));
		}
		if(count.size()==2) return true;
		
		return false;
	}
//sol2
	public int subarraysWithKDistinct(int[] A, int K) {

		  int res = 0, prefix = 0;

		  int[] m = new int[A.length + 1];

		  for (int i = 0, j = 0, cnt = 0; i < A.length; ++i) {

		    if (m[A[i]]++ == 0) ++cnt;

		    if (cnt > K) {

		      --m[A[j++]]; --cnt; prefix = 0; 

		    }

		    while (m[A[j]] > 1) {

		      ++prefix; --m[A[j++]]; 

		    }

		    if (cnt == K) res += prefix + 1;

		  }

		  return res;

		} 


	public static void main(String[] args) {
		
		String s="pqpqs";
				int k=2;
		System.out.println(substringsWithKDistinctChars(s, k));

	}

}
