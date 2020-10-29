import java.util.Arrays;

public class BurstBalloons {
	
	//greedy approach wrong ans
	  public static int maxCoins1(int[] nums) {
	        int[] t=new int[nums.length];
	        int cost=0;
	        for(int i=0;i<nums.length;i++)
	        {
	            t[i]=nums[i];
	        }
	        Arrays.sort(t);
	        for(int j=0;j<t.length;j++)
	        {
	            for(int i=0;i<nums.length;i++)
	             {
	                int left=1;
	                int right=1;
	                if(t[j]==nums[i])
	                {
	                    while(i>0 && nums[i-left]==-1){
	                        
	                        left--;
	                    }
	                    while(i+right <nums.length && nums[i+right]==-1){
	                        
	                        right++;
	                    }
	                    int min=i> 0? nums[i-left] : 1;
	                    int max=i<nums.length-1? nums[i+right] :1;
	                    cost=cost+(nums[i]*min*max);
	                    System.out.println("added="+nums[i]*min*max);
	                    System.out.println("cost"+cost);   
	                    nums[i]=-1;
	                    break;
	                }
	                
	              }
	        }
	        return cost;
	        
	    }
	  public static int maxCoins(int[] nums1) {
	        int[] nums=new int[nums1.length+2];
	        int n=1;
	        for(int x:nums1)
	        {
	        	if(x>0)
	        	{
	        	nums[n++]=x;
	        	System.out.println(n);
	        	}
	        }
	        nums[0]=nums[n++]=1;
	        int[][]memo=new int[n][n];
	        System.out.println(n);
	        return burst(memo,nums,0,n-1);
	  }

	private static int burst(int[][] memo, int[] nums, int left, int right) {
		
		if(left+1 ==right)return 0;
		if(memo[left][right] >0)
			return memo[left][right];
		int ans=0;
		for(int i=left+1;i<right;++i)
		{
			ans=Math.max(ans, nums[left]*nums[i]*nums[right] +burst(memo,nums,left,i)+burst(memo,nums,i,right));
		
		}
		memo[left][right]=ans;

		return ans;
	}
	public static void main(String[] args) {
		int[] nums= {3,1,5,8};
		 System.out.println(maxCoins(nums));

	}

}
