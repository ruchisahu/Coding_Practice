import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/binary-tree-cameras/
public class BinaryTreeCameras968 {
	 static int ans;
	    static Set<TreeNode> covered;
	    public static int minCameraCover(TreeNode root) {
	        ans = 0;
	        covered = new HashSet();
	        covered.add(null);

	        dfs(root, null);
	        return ans;
	    }

	    public static void dfs(TreeNode node, TreeNode par) {
	    	
	        if (node != null) {
	        	System.out.println(node.val);
	            dfs(node.left, node);
	            dfs(node.right, node);

	            if (par == null && !covered.contains(node) ||
	                    !covered.contains(node.left) ||
	                    !covered.contains(node.right)) {
	            	System.out.println("added node for camera : "+node.val);
	                ans++;
	                covered.add(node);
	                covered.add(par);
	                covered.add(node.left);
	                covered.add(node.right);
	            }
	        }
	    }
	

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		System.out.println(minCameraCover(root));

	}

}
