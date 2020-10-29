



	public class Minmax
	{
		int []nums;
		public int maxind=0, minind=1;
		
		public Minmax(int [] numsV,int k)
		{
			nums = numsV;
			
			if(nums[0] < nums [1])
			{
				maxind = 1;minind =0;
			}
			else 
			{
				maxind = 0;minind =1;
			}
			for (int i =2;i<k ;i++)
			{
				if((nums[minind] <= nums [k]) && (nums[maxind] <= nums [k]))
				{
					minind = maxind;
					maxind =k;
				}
				else if((nums[minind] <= nums [k]) && !(nums[maxind] <= nums [k]))
				{
					minind =k;
				}
				else if(!(nums[minind] <= nums [k]) && !(nums[maxind] <= nums [k]))
				{
					//no op
				}
				else
				{
					//error;
				}
				
			}
			
			
			
		}
		
		public int ComputeMax(int ignore, int add)
		{
			if (maxind == ignore)
			{
				if(nums[minind] <= nums[add] )
					maxind = add;
				
			}
				maxind = add;
			if(minind == ignore)
				minind = add;
			
			if(nums[maxind] < nums [minind])
				maxind = minind;
			
			return maxind;
		}
	}

