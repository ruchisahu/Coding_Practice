
public class CountGoodNode1448 {
	 int count = 0;
	    public int goodNodes(TreeNode root) {
	        dfs(root,root.val);
	        return count;
	    }
	    private void dfs(TreeNode node, int max){
	        if(node==null) return;
	        if(node.val>=max){
	            max = node.val;
	            count++;
	        }
	        dfs(node.left, max);
	        dfs(node.right, max);
	    }   
}
