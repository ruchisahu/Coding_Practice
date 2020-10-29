import java.util.*;
import java.util.List;

public class Queue {
	class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) 
	    {
	         List<List<Integer>> result= new ArrayList<List<Integer>>();
	    
	        if(root==null)
	            return result;
	     
	        
	        Deque<TreeNode> q = new LinkedList<TreeNode>();
	        
	        q.offer(root);
	        while(!q.isEmpty())
	        {
	            int size=q.size();
	            List<Integer> curr=new ArrayList<Integer>();
	            for(int i=0;i<size;i++)
	            {
	                TreeNode n=q.poll();
	                curr.add(n.val);
	                 if(n.left!=null) q.add(n.left);
	                if(n.right!=null) q.add(n.right);
	            }
	            result.add(curr);
	        }
	        return result;
	    }
	}
	
	
}
