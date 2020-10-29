import java.util.ArrayList;
import java.util.List;

/*
  A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 */
public class Partition {
	
	 public static List<Integer> partitionLabels(String S) {
	        List<Integer> part =new ArrayList<Integer>();
	        List<String> partS =new ArrayList<String>();
	        int[] lastindex=new int[26];
	        for(int i=0;i<S.length();i++)
	        {
	            lastindex[S.charAt(i)-'a']=i;
	        }
	        
	        int i=0;
	        
	        while(i <S.length())
	        {
	            int end=lastindex[S.charAt(i)-'a'];
	           int j=i;
	            while(j !=end)
	            {
	                end=Math.max(end, lastindex[S.charAt(j++) -'a']);
	            }
	            part.add(j-i+1);
	            partS.add(S.substring(i,j+1));
	            System.out.println("string="+partS);
	                i=j+1;
	        }
	        System.out.println(part);
	        return part;
	    }
	//sol2
	 public List<Integer> partitionLabels1(String S) {

	        if(S==null) return null;

	        List<Integer> partition = new ArrayList<Integer>();

	        int[] last = new int[26];

	        

	        for(int i=0;i<S.length();i++){

	            last[S.charAt(i)-'a'] = i;

	        }

	        int start = 0;

	        int end = 0;

	        for(int i=0;i<S.length();i++){

	            int lastPosition = last[S.charAt(i)-'a'];

	            end = Math.max(end,lastPosition);  

	            

	            if(i==end){

	                partition.add(end-start+1);

	                start = i+1;

	            }

	            

	        }

	        return partition;

	    }

	
	public static void main(String[] args)
	{
		String S="ababcbacadefegdehijhklij";
		partitionLabels(S);
		String S1="a";
		partitionLabels(S1);

	}

}
