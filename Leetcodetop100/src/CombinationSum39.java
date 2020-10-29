//https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
/*

 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
The same repeated number may be chosen from candidates unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
import java.util.*;
public class CombinationSum39 {
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(nums,target,list,new ArrayList<>(),0);
	    return list;
	}

	private static void backtrack(int[] nums, int target, List<List<Integer>>list,List<Integer>temp, int index) {
		
		if(target<0)return;
		if(target==0)
			list.add(new ArrayList<Integer>(temp));
		for(int i=0;i<nums.length;i++)
		{
			if(i>0 && nums[i] ==nums[i-1]) continue;
			temp.add(nums[i]);
			backtrack(nums, target-nums[i], list,temp, index);
			temp.remove(temp.size()-1);
			
		}
		
	}
	
	//sol2  error
	public static List<List<Integer>> combine1(int[] nums, int k) 
    {
		 Arrays.sort(nums);
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	         if(nums == null || nums.length ==0)
	        return result;
	       
	 List<Integer> tmp = new ArrayList<Integer>();
	 result.add(tmp);
	 
	 for (int i=0; i<nums.length; i++)
	 {
	  int n =  result.size();
	  for(int j=0; j<n; j++)
	  {
	 
	   tmp = new ArrayList<Integer>(result.get(j));
	   tmp.add(nums[i]);
	      if(!result.contains(tmp) && sum(tmp)==k)
	   result.add(new ArrayList<Integer>(tmp));
	  }     
	 }
	 return result;
     }
	
	public static int sum(List<Integer> tmp)
	{
		int sum=0;
		for (int i : tmp) {
	         sum = sum + i;
	     }
		return sum;
	}
    

	public static void main(String[] args) {
		int[] nums= {2,3,5};
		int target=8;
		System.out.println(combinationSum(nums,target));
		//System.out.println(combine1(nums,target));

	}

}
