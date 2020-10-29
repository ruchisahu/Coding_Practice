
public class MinMax
{
	int []nums;
	int maxind=0, minind=1;
	
	public MinMax(int [] numsV)
	{
		nums = numsV;
		if(nums[maxind] < nums [minind])
			maxind = minind;
		
	}
	
	public int ComputeMax(int ignore, int add)
	{
		if (maxind == ignore)
			maxind = add;
		if(minind == ignore)
			minind = add;
		
		if(nums[maxind] < nums [minind])
			maxind = minind;
		
		return maxind;
	}
}