
public class MaximumPathSum {
	int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        findMaxSum(root);
        
        return maxSum;
    }
    
   int findMaxSum(TreeNode root) {
       if(root == null)
            return 0;
        
        int leftSum = findMaxSum(root.left);
        int rightSum = findMaxSum(root.right);
       
       //discard if LeftSum or right Sum is < 0.
        leftSum = leftSum > 0 ? leftSum : 0;
        rightSum = rightSum > 0 ? rightSum : 0;
       
        int sum = leftSum + rightSum + root.val;
        // Stored the current max in maxSum
        maxSum = Math.max(maxSum, sum);
        
        // return the Max Sum of Left Side or right side.
        return  Math.max(leftSum, rightSum) + root.val;
   }


	public static void main(String[] args) {
		MaximumPathSum s=new MaximumPathSum();
		TreeNode root = TreeSample.SecondMinimum();
		 System.out.println(s.maxPathSum(root));

	}

}
