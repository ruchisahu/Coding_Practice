import java.util.ArrayList;
import java.util.List;

public class PermuteNumber {
	 List<List<Integer>> result=new ArrayList<List<Integer>>();
	 int count=0;
	    public List<List<Integer>> permute(int[] nums) 
	    {
	        permute(nums, 0);
	        return result;
	    }
	   public void permute(int[] nums, int start) 
	   {
	    for(int i = start; i < nums.length; i++){
	        int temp = nums[start];
	        nums[start] = nums[i];
	        nums[i] = temp;
	      
	        permute(nums, start + 1);
	        nums[i] = nums[start];
	    
	        nums[start] = temp;
	    }
	    if (start == nums.length - 1)
	    {
	        List<Integer> temp=new ArrayList<Integer>();
	       for( int s : nums ) 
	       {
	                  temp.add(s);
	       }
	       count++;
	       System.out.println("count="+count +"temp="+temp);
	       result.add(temp);
	      
	    }
	   }
	public static void main(String[] args) {
		PermuteNumber m=new PermuteNumber();
		int[] nums= {1,2,3};
		System.out.println(m.permute(nums));
	}

}
