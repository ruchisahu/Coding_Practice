import java.util.*;

public class KthSmallestBST230 {
	 public static int kthSmallest(TreeNode root, int k) {
		 List<Integer>list=new ArrayList<Integer>();
		 helper(root,list);
		return list.get(k-1);
	        
	    }

	private static List<Integer> helper(TreeNode root, List<Integer> list) {
		if(root==null)
			return list;
		helper(root.left,list);
		list.add(root.val);
		helper(root.right,list);
		return list;
		
		
	}

	public static void main(String[] args) {
		TreeNode head = TreeSample.createbstTree();
		 System.out.println(kthSmallest(head, 1));

	}

}
