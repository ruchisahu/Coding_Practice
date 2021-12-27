/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.
 */

public class FindMinimumInRotatedSortedArray {
    public static int FindMin(int[] nums){
        if(nums == null || nums.length == 0){
            throw new NegativeArraySizeException("Array does not exist or is empty.");
        }

        if(nums[0] < nums[nums.length-1]) return nums[0];

        int start = 0;
        int end = nums.length-1;

        while(start < end){
            int mid = (start + end)/2;
            if(nums[0] <= nums[mid]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String args[]){
        int[] arr = {3,4,5,6,1,2};
        int num = FindMin(arr);

        System.out.println(num);
    }

}
