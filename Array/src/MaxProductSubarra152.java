
public class MaxProductSubarra152 {
//some issue
	public static int maxProduct(int[] nums) {
	int max = Integer.MIN_VALUE, product = 1;
	int len = nums.length;
	for(int i=0;i<len;i++) {
		max=Math.max(product=product*nums[i], max);
		 if (nums[i] == 0) product = 1;
	}
	 product = 1;
	 for(int i = len - 1; i >= 0; i--) {
	     max = Math.max(product *nums[i], max);
	     if (nums[i] == 0) product = 1;
	 }

	return max;
        
    }
//sol2
public static int maxProduct1(int[] nums) {
	int maxSoFar = nums[0]; // max so far
       int currentCount = 1; 
       
		 
       for(int i=0;i < nums.length ; i++)
       {  // first pass  selects first even signs from the odd numbers of minus numbers
          if(currentCount == 0)
          {
        	  currentCount = 1;} // if zero encountered, start from the beginning
           currentCount = currentCount * nums[i];
          maxSoFar = Math.max(maxSoFar, currentCount);
       }
       currentCount = 1;
       for(int j = nums.length - 1; j > 0 ; j--)
       { // second pass selects last even signs from the odd numbers of minus numbers
           if(currentCount == 0)
           {
        	   currentCount = 1;
           
           } 
           // if zero encountered, start from the beginning
           currentCount = currentCount * nums[j];
           maxSoFar =  Math.max(maxSoFar,currentCount);
       }
       
       
       return maxSoFar;
       
   }

	public static void main(String[] args) {
		int[] nums= {2,3,-2,-4,-5,-6,-1};
		System.out.println(maxProduct1(nums));

	}

}
