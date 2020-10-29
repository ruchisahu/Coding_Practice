/*
 * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
Example 1:
Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

Output: 7 
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobber337 {
	
	public static int rob(TreeNode root)
    {
        if (root == null) return 0;
        int count=0;
        if (root.left != null) {
            count += rob(root.left.left) + rob(root.left.right);
        }
        
        if (root.right != null) {
            count += rob(root.right.left) + rob(root.right.right);
        }
        
        return Math.max(count+root.val, rob(root.left)+rob(root.right));
    }
	
	//sol2
	public int rob1(TreeNode root) {
	    if(root == null) return 0; 
	    
	    int[] sums = robSubSum(root);
	    return Math.max(sums[0], sums[1]); 
	}

	private int[] robSubSum(TreeNode root) {
	    if(root == null) return new int[]{0,0}; 
	    
	    int[] leftSum = robSubSum(root.left); 
	    int[] rightSum = robSubSum(root.right); 
	    
	    int[] sums = new int[2]; 
	    // case of skip this node 
	    sums[0] = Math.max(leftSum[0],leftSum[1]) + Math.max(rightSum[0],rightSum[1]);  
	    // case of count this node 
	    sums[1] = Math.max(sums[0], root.val + leftSum[0] + rightSum[0]); 
	    
	    return sums; 
	}

	public static void main(String[] args) {
		TreeNode root = TreeSample.createbstTree();
		System.out.println(rob(root));
		

	}

}
