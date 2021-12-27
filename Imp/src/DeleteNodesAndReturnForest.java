import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesAndReturnForest {

    public static List<Integer> delNodes(TreeNode root, int[] to_delete) {
        List<Integer> res  = new ArrayList<>();
        if(root == null) return res;

        HashSet<Integer> set = new HashSet<>();
        for(int i : to_delete){
            set.add(i);
        }

        dfs(root,set,res);
        if(!set.contains(root.val)){
            res.add(root.val);
        }
        return res;
    }

    private static TreeNode dfs(TreeNode root,HashSet<Integer> set,List<Integer> res){
        if(root == null) return null;

        root.left = dfs(root.left,set,res);
        root.right = dfs(root.right,set,res);
        if(set.contains(root.val)){
            if(root.left != null){
                res.add(root.left.val);
            }
            if(root.right != null){
                res.add(root.right.val);
            }
            return null;
        }
        return root;
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
