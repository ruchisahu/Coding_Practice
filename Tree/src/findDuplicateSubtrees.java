 import java.util.*;
//https://leetcode.com/problems/find-duplicate-subtrees/
public class findDuplicateSubtrees {
	 static Map<String, Integer> count;
	    static List<TreeNode> ans;
	    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        count = new HashMap();
	        ans = new ArrayList();
	        collect(root);
	      //  for(int i=0;i<ans.size();i++)
	        	//System.out.println(ans.get(i));
	        return ans;
	    }

	    public static String collect(TreeNode node) {
	        if (node == null) return "#";
	        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
	        count.put(serial, count.getOrDefault(serial, 0) + 1);
	        if (count.get(serial) == 2) {
	        	  ans.add(node);
	        	  System.out.println("duplicate subtree:  "+serial);
	        }
	            ans.add(node);
	        return serial;
	    }
	

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree652();
		System.out.println(findDuplicateSubtrees(root));
		//System.out.println(".............");
		

	}


}
