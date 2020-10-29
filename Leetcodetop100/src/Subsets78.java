import java.util.*;

public class Subsets78 {
	  public List<List<Integer>> subsets(int[] nums) {
		  List<List<Integer>> result=new ArrayList<List<Integer>>();
		  List<Integer> tmp = new ArrayList<Integer>();
		  result.add(tmp);

		  for(int i=0;i<nums.length;i++)
		  {
			  int len=result.size();
			  for(int j=0;j<len;j++) 
			  {
				  
				  tmp=new ArrayList<Integer>(result.get(j));
				  tmp.add(nums[i]);
				  if(!result.contains(tmp))
				  {
					  
					   result.add(new ArrayList<Integer>(tmp));
					   System.out.println(".................");
					   for(int i1=0;i1<tmp.size();i1++)
						  {
						   System.out.println(tmp.get(i1));
						  }
					   
				  }

				  
			  }
		  }
		  
		return result;
	        
	    }

	public static void main(String[] args) {
		 Subsets78 s=new  Subsets78();
		
		int[] nums= {1,2,3,4};
		s.subsets(nums);

	}

}
