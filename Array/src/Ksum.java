import java.util.*;

public class Ksum {
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> result = new ArrayList<> ();
	        if (nums == null || nums.length == 0) {
	            return result;
	        }
	        Arrays.sort(nums);
	        List<Integer> list = new ArrayList<> ();
	        kSum(nums, target, 4, result, list, 0);
	        return result;
	    }
	    private static void kSum(int[] nums, int target, int k, List<List<Integer>> result, List<Integer> list, int index) {
	        if (k == 2) {
	            int start = index;
	            int end = nums.length - 1;
	            while (start < end) {
	                if (nums[start] + nums[end] == target) {
	                    list.add(nums[start]);
	                    list.add(nums[end]);
	                    result.add(new ArrayList<> (list));
	                    list.remove(list.size() - 1);
	                    list.remove(list.size() - 1);
	                    while (start < end && nums[start] == nums[start + 1]) {
	                        start++;
	                    }
	                    start++;
	                    while (start < end && nums[end] == nums[end - 1]) {
	                        end--;
	                    }
	                    end--;
	                } else if (nums[start] + nums[end] > target) {
	                    end--;
	                } else {
	                    start++;
	                }
	            }
	            return;
	        }
	        for (int i = index; i < nums.length; i++) {
	            if (i == index || nums[i] != nums[i - 1]) {
	                list.add(nums[i]);
	                kSum(nums, target - nums[i], k - 1, result, list, i + 1);
	                list.remove(list.size() - 1);
	            }
	        }
	    }
	

	public static void main(String[] args) {
		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		fourSum(nums,target);

	}

}
