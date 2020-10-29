
public class LowestcommonansesterBinary
{
	   private Node root;
	   public static Node lowestCommonAncestor(Node root, Node p, Node q) 
	   {
		    if (root == null || root == p || root == q)
		    	return root;
		    Node left= lowestCommonAncestor(root.left,  p,  q);
		    Node right= lowestCommonAncestor(root.right,  p,  q);
		    
		       
		    return left == null ? right : right == null ? left : root;
	   }
	 /* Driver program to test above functions */
	    public static void main(String args[]) 
	    { 
	    	LowestcommonansesterBinary tree = new LowestcommonansesterBinary(); 
	        tree.root = new Node(1); 
	        tree.root.left = new Node(2); 
	        tree.root.right = new Node(3); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.left = new Node(6); 
	        tree.root.right.right = new Node(7); 
	        
	       // tree.lowestCommonAncestor(1, 4,7);
	    } 
	} 
	class Node 
	{ 
	    int data; 
	    Node left, right; 
	  
	    public Node(int item) 
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 