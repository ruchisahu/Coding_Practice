import java.util.*;

public class InOrderTraversal
{
	public List<Integer> inorderTraversal(TreeNode root)
	{
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 注意 stack isEmpty 的条件，否则得不到完整的解
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

	

}
