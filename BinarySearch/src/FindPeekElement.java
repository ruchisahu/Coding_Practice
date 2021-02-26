
public class FindPeekElement {
	public static int findPeakElement(int[] nums) {
	       int low = 0;
	        int high = nums.length-1;
	        
	        while(low < high)
	        {
	            int mid1 = (low+high)/2;
	            int mid2 = mid1+1;
	            if(nums[mid1] < nums[mid2])
	                low = mid2;
	            else
	                high = mid1;
	        }
	        return low;
	    }
    
	 public static void main(String[] args) {
	 System.out.println(findPeakElement(new int[] { 1,2,1,3,5,6,4 }));


}
}
