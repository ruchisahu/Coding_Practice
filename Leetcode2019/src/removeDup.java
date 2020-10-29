
public class removeDup {

	
	    public static int removeDuplicates(int[] nums) {
	        if (nums == null) return -1;
	        if (nums.length <= 2) return nums.length;

	        int newIndex = 1;
	        for (int i = 2; i < nums.length; i++) 
	        {
	            if (nums[i] != nums[newIndex] || nums[i] != nums[newIndex - 1]) {
	                newIndex++;
	                nums[newIndex] = nums[i];
	            }
	        }

	        return newIndex + 1;
	    }
	
	public static void main(String[] args) {
		int[] nums= {1,1,2,3};
		 System.out.println(removeDuplicates(nums));

	}

}
