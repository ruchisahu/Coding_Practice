
public class TrappingRainWater42 {
	//sol2
public static int trap1(int[] height)
	{
	 if(height ==null)return 0;
	 
		return 0;
	}	
public static int trap(int[] height) {
	int left=0,right=height.length-1;
    int left_max=0,right_max=0,ans=0;
    while(left<right)
    {
        if(height[left]<height[right])
        {
           left_max=Math.max(left_max,height[left]); 
               ans=ans+(left_max-height[left]);
                left++;
                System.out.println("left  "+ans);
        }
        else
        {
             right_max=Math.max(right_max,height[right]); 
                 ans += (right_max - height[right]);
        --right;
        System.out.println("right  "+ans);
        }
       
    }
    return ans;

        
    }

	public static void main(String[] args) {
		

		// TODO Auto-generated method stub
		int[] h= {0,1,0,2,1,0,1,3,2,1,2,1};
		 System.out.println(trap(h));

	}

}
