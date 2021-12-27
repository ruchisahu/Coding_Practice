public class BinaryTreeLongestConsecutiveSequence {
    static int res = 0;
    public static int BTLCS(TreeNode root){
        if(root == null) return 0;
        helper(root,1,null);
        return res;
    }
    public static void helper(TreeNode root, int len, TreeNode parent){
        if(root == null) return;

        if(parent != null){
            len = parent.val - root.val == 1 ? len + 1 : 1;
        }

        res = Math.max(res, len);

        helper(root.left,len,root);
        helper(root.right,len,root);
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);

        System.out.println(BTLCS(root));
     }
}
