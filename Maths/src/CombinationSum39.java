import java.util.*;

public class CombinationSum39 {
	public List<List<Integer>> combinationSum(int[] nums, int target) {
	    List<List<Integer>> list = new ArrayList<>();
	    Arrays.sort(nums);
	    backtrack(list, new ArrayList<>(), nums, target, 0);
	    return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
	    if(remain < 0) return;
	    else if(remain == 0) list.add(new ArrayList<>(tempList));
	    else{ 
	        for(int i = start; i < nums.length; i++){
	            tempList.add(nums[i]);
	           backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
	         //   backtrack(list, tempList, nums, remain - nums[i], i+1);
	            tempList.remove(tempList.size() - 1);
	        }
	    }
	}


	public static void main(String[] args) {
		int[] nums = {2,3,6,7};
		int target = 7;
		CombinationSum39 c=new CombinationSum39();
		System.out.println(c.combinationSum(nums, target));

	}

}
