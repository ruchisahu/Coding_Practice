import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
public class BinaryTreeVerticalOrderTraversal {
	private int min = 0;
	private int max = 0;
	    public int verticalOrder(TreeNode root) {
	        if(root==null) return 0;
	        helper(root,0);
	        Set<Integer> set = new HashSet<>();

	        Queue<TreeNode> nodeQueue=new ArrayDeque<>();
	        nodeQueue.offer(root);
	        Queue<Integer> levelQueue = new ArrayDeque<>();
	        levelQueue.offer(-min);

	        while(!nodeQueue.isEmpty()){
	            int level=levelQueue.poll();
	            set.add(level);
	            TreeNode currentNode=nodeQueue.poll();
	            if(currentNode.left!=null){
	                nodeQueue.offer(currentNode.left);
	                levelQueue.offer(level-1);
	            }
	            if(currentNode.right!=null){
	                nodeQueue.offer(currentNode.right);
	                levelQueue.offer(level + 1);
	            }
	        }
	        
	        return set.size();
	    }
	    
	        public void helper(TreeNode root, int index){
	        if(root==null) return;
	        min=Math.min(min,index);
	        max=Math.max(max,index);
	        helper(root.left,index-1);
	        helper(root.right,index+1);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
