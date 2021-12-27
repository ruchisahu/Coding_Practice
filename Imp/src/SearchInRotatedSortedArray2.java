/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.
 */

public class SearchInRotatedSortedArray2 {
    public static boolean Search2(int[] nums, int target){
        if(nums == null || nums.length == 0){
            throw new NegativeArraySizeException("Array is empty.");
        }

        int start = 0;
        int end = nums.length-1;

        while(start + 1 < end){
            int mid = (start + end)/2;

            if(nums[mid] == target) return true;

            if(nums[start] < nums[mid]){
                if(target >= nums[start] && target <= nums[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else if(nums[mid] < nums[end]){
                if(target >= nums[mid] && target <= nums[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }

        if(target == nums[start] || target == nums[end]) return true;
        return false;
    }

    public static void main(String args[]){
        int[] arr = {4,5,6,0,1,2,3};
        int target = 8;
        boolean flag = Search2(arr,target);

        System.out.println(flag);
    }

}
