import java.util.*;

public class SerializeDeserializeTree297 {
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	 return serial(new StringBuilder(), root).toString();
        
    }
    private static StringBuilder serial(StringBuilder str, TreeNode root) {
    	if(root==null)return str.append("#");
    	str.append(root.val).append(",");
    	serial(str, root.left).append(",");
        serial(str, root.right);
		return str;
    	
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	 return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
    }
 // Use queue to simplify position move
    private static TreeNode deserial(Queue<String> q) {
    	String val = q.poll();
        if ("#".equals(val)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(q);
        root.right = deserial(q);
        return root;
    	
    }
    
    //sol2
    public String serialize1(TreeNode root) {

        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();

        StringBuilder res = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {

                res.append("n ");

                continue;

            }

            res.append(node.val + " ");

            q.add(node.left);

            q.add(node.right);

        }

        return res.toString();

    }



    public TreeNode deserialize1(String data) {

        if (data == "") return null;

        Queue<TreeNode> q = new LinkedList<>();

        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        q.add(root);

        for (int i = 1; i < values.length; i++) {

            TreeNode parent = q.poll();

            if (!values[i].equals("n")) {

                TreeNode left = new TreeNode(Integer.parseInt(values[i]));

                parent.left = left;

                q.add(left);

            }

            if (!values[++i].equals("n")) {

                TreeNode right = new TreeNode(Integer.parseInt(values[i]));

                parent.right = right;

                q.add(right);

            }

        }

        return root;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s="5,3,#,1,#,#,10,2,#,#,7,#,#";
        TreeNode root = TreeSample.createbstTree();
       System.out.println(serialize(root));
       
       System.out.println(deserialize(s));
	}

}
