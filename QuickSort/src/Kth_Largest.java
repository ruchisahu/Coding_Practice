import java.util.Arrays;

public class Kth_Largest {
	public static int findKthLargest(int[] nums, int k) {
		  return quickSelect(nums, 0, nums.length - 1, k);
		}

		static int quickSelect(int[] nums, int low, int high, int k) {
		  int pivot = low;

		  // use quick sort's idea
		  // put nums that are <= pivot to the left
		  // put nums that are  > pivot to the right
		  for (int j = low; j < high; j++) {
		    if (nums[j] <= nums[high]) {
		      util.swap(nums, pivot++, j);
		    }
		  }
		  util.swap(nums, pivot, high);
		  
		  // count the nums that are > pivot from high
		  int count = high - pivot + 1;
		  // pivot is the one!
		  if (count == k) return nums[pivot];
		  // pivot is too small, so it must be on the right
		  if (count > k) return quickSelect(nums, pivot + 1, high, k);
		  // pivot is too big, so it must be on the left
		  return quickSelect(nums, low, pivot - 1, k - count);
		}
	 


		
	public static void main(String[] args) {
		int[] A = new int[10];
		util.fillWithRandomInts(A);
		//int[] A= {2,8,7,1,3,5,6,4};
		//int[] A= {4,3,2,1};
		System.out.println(Arrays.toString(A));
        int r=A.length-1;
        int p=0;
        int l=findKthLargest(A,2);
		
		System.out.println(l);
	}

}
