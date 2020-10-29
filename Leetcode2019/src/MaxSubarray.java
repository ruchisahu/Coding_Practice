
public class MaxSubarray 
{

	public static int maxProduct(int[] nums)
    {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ 
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            System.out.println("imax="+imax);
            System.out.println("imin="+imin);
            max = Math.max(max, imax);
            System.out.println("max="+max);
        }
        return max;

    }
	public static void main(String[] args)
	{
		int[] nums= {3,-4,5,2,-2};
		System.out.println(maxProduct(nums));
	}

}
