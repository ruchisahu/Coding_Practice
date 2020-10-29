
public class JumpGame 
{
	   public static boolean canJump(int[] nums) 
	    {
		   int maxIndex = nums.length-1;
		    int maxJump  = nums[0];
		    for(int i = 0; i <= maxJump; i++)
		    {
		        maxJump=Math.max(maxJump,i+nums[i]);
		        System.out.println(maxJump);
		        if(maxJump>=maxIndex)
		        	return true;
		    }
		    return false;
	        
	    }
	
	public static void main(String[] args) 
	{
		int[] nums= {1,0,8,0,4};
		System.out.println(canJump(nums));

	}

}
