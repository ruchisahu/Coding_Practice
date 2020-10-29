import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset {
    public static List<List<Integer>> subsetsWithDup(int[] nums)
    {
    	Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<List<Integer>> ();
        List<Integer> set=new ArrayList<Integer>();
        helper(result,set,0,nums);
        return result;
        
    }
    public static void helper(List<List<Integer>> result, List<Integer> set,int pos,int[] nums)
    {
    	if(pos <=nums.length )
    	{
    		//if(!result.contains(set))
    		result.add(set);
    	}
    	int i=pos;
    	while(i <nums.length)
    	{
    		set.add(nums[i]);
    		helper(result,new ArrayList<>(set),i+1,nums);
    		set.remove(set.size()-1);
    		i++;
    		while (i < nums.length && nums[i] == nums[i - 1]) {i++;}
    		
    	}
    	return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {1,2,2};
		System.out.println(subsetsWithDup(nums));
	}

}
