import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Leetcode 428 Serialize and Deserialize N-ary Tree
N-ary Tree是指根节点有N个子节点，BT和BST都只有两个子节点
 */
public class SerializeandDeserializeNaryTree {
    private static class Node{
        int val;
        List<Node> childern;

        public Node(int val){
            this.val = val;
        }
        public Node(int val, List<Node> childern){
            this.val = val;
            this.childern = childern;
        }
    }

    public static String serialize(Node root){
        if(root == null) return "";

        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    public static void preOrder(Node root, StringBuilder sb){
        if(root == null){
            return;
        }

        sb.append(root.val);
        sb.append(",");
        sb.append(root.childern.size());

        for(Node node : root.childern){
            sb.append(",");
            preOrder(node,sb);
        }
    }

    public static Node derialize(String data){
        if(data == null || data.length() == 0) return null;

        String[] nodes = data.split(" ");

        Queue<String> q = new LinkedList<>();

        for(String s : nodes){
            q.add(s);
        }

        return preOrder(q);
    }

    public static Node preOrder(Queue<String> q){
        if(Integer.valueOf(q.poll()) == 0) return null;

        Node root = new Node(Integer.valueOf(q.poll()), new ArrayList<>());
        int size = Integer.valueOf(q.poll());

        for(int i = 0; i < size; i++){
            root.childern.add(preOrder(q));
        }
        return root;
    }

    public static void main(String args[]){
        Node n4 = new Node(5,new ArrayList<>());
        Node n5 = new Node(6,new ArrayList<>());
        List<Node> l2 = new ArrayList<>();
        l2.add(n4);
        l2.add(n5);
        Node n1 = new Node(2,l2);
        Node n2 = new Node(3,new ArrayList<>());
        Node n3 = new Node(4,new ArrayList<>());
        List<Node> list = new ArrayList<>();
        list.add(n1);
        list.add(n2);
        list.add(n3);
        Node root = new Node(1, list);

        System.out.println(serialize(root));
        //System.out.println(derialize(s));

    }
}
