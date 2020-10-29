
public class moveZero283
{
	 public  void moveZeroes(int[] nums) 
	    {
	        int count=0;
	        for(int i=0;i<nums.length;i++)
	        {
	            if(nums[i]==0)
	            {
	                count++;
	                rearrange(i, nums);
	                System.out.println("count"+i+count);
	            }
	        }
	        for(int i=0;i<nums.length;i++)
	        {
	        	System.out.println("before"+nums[i]);
	        }
	        System.out.println("count"+count);
	        int k=0;
	        while(count>0)
	        {
	           
	            nums[nums.length-k-1]=0;
	            k++;
	            count--;
	        }
	        for(int i=0;i<nums.length;i++)
	        {
	        	System.out.println(nums[i]);
	        }
	        }
	    
	    void  rearrange(int i, int[] a)
	    {
	        for(int j=i;j<a.length-1;j++)
	        {
	            a[j]=a[j+1];
	        }
	    }
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[] nums= {0,1,0};
		moveZero283 m=new moveZero283();
		m.moveZeroes(nums);

	}

}
