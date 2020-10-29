import java.util.ArrayList;
import java.util.List;

public class Combinations {

	
	public static List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        if(n<k || k<=0) return result;
        dfs(n, k, 1, list, result);
        return result;
    }
	private static void dfs(int n, int k, int pos, List<Integer> list, List<List<Integer>> result)
	{
		if(list.size()==k)
		{
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=pos;i <=n;i++)
		{
			list.add(i);
			System.out.println(list);
			dfs(n,k,i+1,list,result);
			 list.remove(list.size() - 1);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		int k=2;
		 System.out.println(combine(n,k));
	}

}
