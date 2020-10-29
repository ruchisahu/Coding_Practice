
public class subArraysum560 
{

public static int subarraySum(int[] nums, int k)
{
	int count=0;
	for(int i=0;i<nums.length;i++)
	{
		int sum=0;
		for(int j=i;j<nums.length;j++)
		{
			sum=sum+nums[j];
					if(sum==k)
						count++;
		}
	}
       return count; 
 }
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int[]nums= {1,1,1};
		int k=2;
		System.out.println(subarraySum(nums, k));
	}

}
