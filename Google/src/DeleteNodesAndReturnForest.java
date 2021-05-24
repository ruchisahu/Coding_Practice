import java.util.*;

public class DeleteNodesAndReturnForest {
	public static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> result = new ArrayList<TreeNode>();
		 if(root == null) return result;

	        HashSet<Integer> set = new HashSet<>();
	        for(int i : to_delete){
	            set.add(i);
	        }
	        if(!set.contains(root.val))result.add(root);
	        dfs(root,set,result,null,false);
		
		return result;
        
    }
	 private static void dfs(TreeNode node, Set<Integer> delSet, List<TreeNode> result, TreeNode parent, boolean isLeftChild) {
	        if (delSet.isEmpty() || node == null) return;
	        if (delSet.contains(node.val)) {
	            if (node.left != null && !delSet.contains(node.left.val)) result.add(node.left);
	            if (node.right != null && !delSet.contains(node.right.val)) result.add(node.right);
	            if (parent != null && isLeftChild) parent.left = null;
	            if (parent != null && !isLeftChild) parent.right = null;
	            delSet.remove(node.val);
	        }
	        dfs(node.left, delSet, result, node, true);
	        dfs(node.right, delSet, result, node, false);
	    }
	
//sol2 bfs
	 private List<TreeNode> forest = new ArrayList<>();
	    private Set<Integer> delSet = new HashSet<>();
	    
	    public List<TreeNode> delNodes1(TreeNode root, int[] to_delete) {
	        if (root == null) {
	            return new ArrayList<>();
	        }
	        
	        for (int x : to_delete) {
	            delSet.add(x);
	        }
	        
	        forest.add(root);
	        buildForest(root, null);
	        return forest;
	    }
	    
	    private void buildForest(TreeNode node, TreeNode parent) {
	        if (node == null) {
	            return;
	        }
	        if (delSet.contains(node.val)) {
	            forest.remove(node);
	            if (node.left != null) {
	                forest.add(node.left);
	            }
	            if (node.right != null) {
	                forest.add(node.right);
	            }
	            if (parent != null) {
	                if (parent.left == node) {
	                    parent.left = null;
	                } else {
	                    parent.right = null;
	                }
	            }
	        }
	        buildForest(node.left, node);
	        buildForest(node.right, node);
	    }
	
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(delNodes(root, new int[]{3,5}));
    }
}


