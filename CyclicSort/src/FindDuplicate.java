//https://leetcode.com/problems/find-the-duplicate-number/solution/
public class FindDuplicate {
	 public static int findDuplicate(int[] nums) {
	        int i = 0;
	        while (i < nums.length) {
	            if (nums[i] != i+1) {
	                if (nums[nums[i]-1] == nums[i]) return nums[i];
	                int temp = nums[nums[i]-1];
	                nums[nums[i]-1] = nums[i];
	                nums[i] = temp;
	            } else i++;
	        }
	        return -1; 
	    }

	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println(findDuplicate(nums));

	}

}
