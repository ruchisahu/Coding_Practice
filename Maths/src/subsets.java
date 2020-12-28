import java.util.*;

//https://leetcode.com/problems/subsets/solution/
//O(n* 2^n)
public class subsets {
	public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
		  List<Integer> tmp = new ArrayList<Integer>();
		  result.add(tmp);

		  for(int i=0;i<nums.length;i++)
		  {
			  int len=result.size();
			  for(int j=0;j<len;j++) 
			  {
				  
				  tmp=new ArrayList<Integer>(result.get(j));
				  tmp.add(nums[i]);
				  if(!result.contains(tmp))
					   result.add(new ArrayList<Integer>(tmp));

				  
			  }
		  }
		  
		return result;
   }

	public static void main(String[] args) {
		int[] nums= {1,2,3};
		System.out.println(subsets(nums));

	}

}
