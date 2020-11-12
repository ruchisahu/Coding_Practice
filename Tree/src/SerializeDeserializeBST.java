import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST {
	 // Encodes a tree to a single string.
	   public static String serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        serialize(root, sb);
	        return sb.toString();
	    }
	    
	    public static void serialize(TreeNode root, StringBuilder sb) {
	        if (root == null) return;
	        sb.append(root.val).append(",");
	        serialize(root.left, sb);
	        serialize(root.right, sb);
	    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if(data.isEmpty())return null;
    	 Queue<Integer> queue = new LinkedList<>();
    	String[] tokens=data.split(",");
    	for(String s:tokens) {
    		queue.add(Integer.parseInt(s));
    	}
    	 return deserialize(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

	private static TreeNode deserialize(Queue<Integer> queue, int minValue, int maxValue) {
		
		if(queue.isEmpty())return null;
		int val=queue.poll();
		TreeNode root=new TreeNode(val);
		 root.left = deserialize(queue, minValue, val);
	     root.right = deserialize(queue, val, maxValue);
	     return root;
		
	}

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		String s=serialize(root);
		System.out.println(s);
		//String data="5,3,1,10,2,7";
		String data="2,1,3";
		TreeNode root2=deserialize(s);
		InOrder in=new InOrder();
		in.Traversal(root2);
		
		

	}

}
