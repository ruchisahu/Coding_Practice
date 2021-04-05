
public class TrappingRain {
	 public static int trap(int[] height)
	    {
	        int left=0,right=height.length-1;
	        int left_max=0,right_max=0,ans=0;
	        while(left<right)
	        {
	            if(height[left]<height[right])
	            {
	               left_max=Math.max(left_max,height[left]); 
	                   ans=ans+(left_max-height[left]);
	                    left++;
	            }
	            else
	            {
	                 right_max=Math.max(right_max,height[right]); 
	                     ans += (right_max - height[right]);
	            --right;
	            }
	        }
	        return ans;
	    }

	public static void main(String[] args) {
		int[] height = {4,2,0,3,2,5};
		System.out.println(trap(height));


	}

}
