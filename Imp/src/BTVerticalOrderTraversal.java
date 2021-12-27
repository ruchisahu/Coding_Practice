import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class BTVerticalOrderTraversal {

    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q_node = new LinkedList<>();
        Queue<Integer> q_index = new LinkedList<>();
        //HashMap<Integer,List<Integer>> map = new HashMap<>();
        // TreeMap returns key in sorted way
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();

        q_node.add(root);
        q_index.add(0);

        while(!q_node.isEmpty()){
            TreeNode node = q_node.poll();
            int index = q_index.poll();

            if(!map.containsKey(index)){
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(index,list);
            }else{
                map.get(index).add(node.val);
            }

            if(node.left != null){
                q_node.offer(node.left);
                q_index.offer(index - 1);
            }
            if(node.right != null){
                q_node.offer(node.right);
                q_index.offer(index + 1);
            }
        }

        for(List<Integer> l : map.values()){
            res.add(l);
        }
        return res;
     }


    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(14);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(16);

        System.out.println(verticalOrderTraversal(root));
    }

}
