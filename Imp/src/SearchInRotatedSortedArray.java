/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).
 */

public class SearchInRotatedSortedArray {
    public static int Search(int[] nums, int target){
        if(nums == null || nums.length == 0) return -1;

        int start = 0;
        int end = nums.length - 1;

        while(start + 1 < end){
            int mid = (start + end)/2;

            if(nums[mid] == target) return mid;

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

        if(nums[start] == target) return start;
        if(nums[end] == target) return end;
        return -1;
    }

    public static void main (String args[]){
        int[] arr = {3,4,5,0,1,2};
        int target = 9;
        int index = Search(arr,target);
        System.out.println(index);
    }

}
