import java.util.*;

/*
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to target. Return the number of pairs.

Example 1:

Input: nums = [1, 1, 2, 45, 46, 46], target = 47
Output: 2
Explanation:
1 + 46 = 47
2 + 45 = 47
 */
public class UniquePairs {
	public static int getUniquePairs(int[] nums, int target){
	    Arrays.sort(nums);
	    int i = 0;
	    int j = nums.length-1;
	    int ans = 0;
	    while (i < j){
	        int sum = nums[i]+ nums[j];
	        if (sum < target){
	            i++;
	        } else if (sum > target){
	            j--;
	        } else {
	            ans++;
	            i++;
	            j--;
	            while (i < j && nums[i] == nums[i-1]){
	                i++;
	            }
	            while (i < j && nums[j] == nums[j+1]){
	                j--;
	            }
	        }
	    }
	    return ans;
	}
	public static void main(String[] args) {
		int[] nums = {1, 1, 2, 45, 46, 46};
		int target=47;
		System.out.println(getUniquePairs(nums,target));
		

	}

}
