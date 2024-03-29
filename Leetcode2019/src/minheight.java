//310 leetcode
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class minheight {

	    public static List<Integer> findMinHeightTree(int n, int[][] edges) 
	    {
	       if(n==1)return  Arrays.asList(0);
	        
	        List<Set<Integer>> adj=new ArrayList<Set<Integer>>();
	        List<Integer> result=new ArrayList<Integer> ();
	        List<Integer> leave=new ArrayList<Integer> ();
	        for(int j=0;j<n;j++) {
	        	adj.add(new HashSet<>());
	        }
	        for(int[] edge:edges)
	        {
	           
	             adj.get(edge[0]).add(edge[1]);
	            adj.get(edge[1]).add(edge[0]);
	        }
	     //   for(Set<Integer> l:adj)
	     //   System.out.println(l);
	           for(int i=0;i<n;i++)  
	                    {
	                      if(adj.get(i).size()==1)
	                          leave.add(i);
	                    }
	       //    for(Integer lea:leave)
	   	   //     System.out.println(lea);
	           while(n>2)
	           {
	        	   n=n-leave.size();
	        	   List<Integer> newLeaves = new ArrayList<>();
	        	   for(int k : leave)
	        	   {
	        		   int j1=adj.get(k).iterator().next();
	        		   adj.get(j1).remove(k);
	        		   if (adj.get(j1).size() == 1) newLeaves.add(j1);
	        	   }
	        	   leave=newLeaves;
	        	   
	           }
	        return leave;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
    	int[][] edges= {{0,3},{1,3},{2,3},{4,3},{5,4}};
    	System.out.println(findMinHeightTree(n, edges));

	}

}
