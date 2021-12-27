/*
Find the kth largest element in an unsorted array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
*/
public class KthLargest {
    public static int FindKth(int[] nums, int k){
        if(nums.length == 0 || nums.length == 0){
            throw new NegativeArraySizeException("array does not exist");
        }

        int left = 0;
        int right = nums.length-1;

        while(true){
            int pos = partition(nums,left,right);

            if(pos + 1 == k){
                return nums[pos];
            }else if(pos + 1 > k){
                right = right - 1;
            }else if(pos + 1 < k) {
                left = left + 1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right){
        int povit = nums[left];
        int l = left + 1;
        int r = right;

        while(l <= r){
            if (nums[l] < povit && nums[r] > povit) {
                swap(nums,l++,r--);
            }
            if(nums[l] >= povit) l++;
            if(nums[r] <= povit) r--;
        }
        swap(nums,left,r);
        return r;
    }

    public static void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String args[]){
        int[] arr = {3,2,1,5,6,4};
        int k = 5;
        int num = FindKth(arr,k);
        System.out.println(num);
    }
}
