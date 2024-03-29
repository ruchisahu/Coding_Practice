
public class SearchinRotatedSortedArray33 {
	public static int search(int[] nums, int target) {
		int i=0;
		int j=nums.length-1;
		int mid;
		while(i<=j) {
			mid=(i+j)/2;
			if(nums[mid]==target) 
				return mid;
				
				if(nums[mid]>nums[i]) {
					if(target>=nums[i] && target<=nums[mid])
					{
						j=mid-1;
					}
					else
					{
						i=mid+1;
					}
				}
				else
				{
					if(target>nums[mid] && target<nums[j])
					{
						i=mid+1;
					}
					else
						j=mid-1;
				}
			}
		
		return -1;
	}

	public static void main(String[] args) {
		int[] nums= {4,5,6,7,0,1,2};
		int target=6;
		System.out.println(search(nums, target));

	}

}
