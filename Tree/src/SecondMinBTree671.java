
public class SecondMinBTree671 {
	private static int MAX1 = Integer.MAX_VALUE;
    private static int MAX2 = Integer.MAX_VALUE;
    private static boolean flag = true; // if flag never changed, it means that all the nodes' values are the same number, then return -1
    public static int findSecondMinimumValue(TreeNode root) {
        
        helper(root);
        if(flag == true) return -1;
        else return MAX2;
    }
    
    public static void helper(TreeNode node){
        
        if(node == null) return;
        
        if(node.val < MAX1) {
            MAX1 = node.val;    
        }
        if(node.val > MAX1 && node.val <= MAX2) {
            MAX2 = node.val;
            flag = false;
        }
        
        helper(node.left);
        helper(node.right);     
		
	}

	public static void main(String[] args) {
		TreeNode root = TreeSample.SecondMinimum();
		 System.out.println(findSecondMinimumValue(root));

	}

}
