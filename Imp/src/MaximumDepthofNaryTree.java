import java.util.List;

public class MaximumDepthofNaryTree {
    private class Node{
        int val;
        List<Node> children;

        Node(int val){
            this.val = val;
        }
        Node(int val, List<Node> children){
            this.val = val;
            this.children = children;
        }
    }

    public static int maxDepth(Node root){
        if(root == null) return 0;

        int count = 0;
        for(Node node : root.children){
            count = Math.max(count, maxDepth(node));
        }
        return count + 1;
    }

}
