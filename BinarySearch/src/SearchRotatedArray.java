
public class SearchRotatedArray {
	 public static int search(int[] nums, int target) {
	        if (nums.length == 0) return -1;
	        if (nums.length == 1) return nums[0] == target ? 0 : -1;
	        int left = 0, right = nums.length - 1;
	        while (left <= right) {
	            int mid = left + (right - left) / 2;
	            if (nums[mid] == target) {
	                return mid;
	            }
	            if (nums[mid] > nums[right]) {
	                if (target < nums[mid] && target >= nums[left]) {
	                    right = mid - 1;
	                } else {
	                    left = mid + 1;
	                }
	            } else {
	                if (target > nums[mid] && target <= nums[right]) {
	                    left = mid + 1;
	                } else {
	                    right = mid - 1;
	                }
	            }
	        }
	        return -1;
	    }

	    public static void main(String[] args) {
	        System.out.println(SearchRotatedArray.search(new int[] { 10, 15, 1, 3, 8 }, 15));
	        System.out.println(SearchRotatedArray.search(new int[] { 4, 5, 7, 9, 10, -1, 2 }, 10));
	    }

	

}
