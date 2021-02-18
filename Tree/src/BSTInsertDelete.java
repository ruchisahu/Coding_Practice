
public class BSTInsertDelete {
	//inorder
	public static void inorder(TreeNode root)
    {
        if (root == null) {
            return;
        }
 
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
	
	// Helper function to find minimum value node in the subtree rooted at `curr`
    public static TreeNode minimumKey(TreeNode curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
 // Recursive function to insert a key into a BST
    public static TreeNode insert(TreeNode root, int key)
    {
    	if(root==null)return new TreeNode(key);
    	if(key<root.val) {
    		root.left=insert(root.left,key);
    	}
    	else {
    		root.right=insert(root.right,key);
    	}
    	return root;
    }
    
 // Function to delete a node from a BST
    public static TreeNode deleteNode(TreeNode root, int key)
    {
    	TreeNode parent=null;
    	TreeNode curr=root;
    	while(curr!=null && curr.val!=key) {
    		parent =curr;
    		if(key<curr.val) {
    			curr=curr.left;
    		}
    		else {
    			curr=curr.right;
    		}
    	}
    	//if not found
    	if(curr==null)return root;
    	//Case 1: node to be deleted has no children
    	if(curr.left==null && curr.right==null) {
    		if(curr!=root) {
    			if(parent.left==curr)parent.left=null;
    			else parent.right=null;
    		}
    	
    	else
    		root=null;
    	}
    	// Case 2: node to be deleted has two children
    	if(curr.left!=null && curr.right!=null) {
    		TreeNode successor= minimumKey(curr.right);
    		int val=successor.val;
    		// recursively delete the successor. Note that the successor
            // will have at most one child (right child)
            deleteNode(root, successor.val);
 
            // copy value of the successor to the current node
            curr.val = val;
    	}
    	// Case 3: node to be deleted has only one child
        else
        {
            // choose a child node
            TreeNode child = (curr.left != null)? curr.left: curr.right;
 
            // if the node to be deleted is not a root node, set its parent
            // to its child
            if (curr != root)
            {
                if (curr == parent.left) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }
 
            // if the node to be deleted is a root node, then set the root to the child
            else {
                root = child;
            }
        }
 
        return root;
    }
    
    
    
	
	

	public static void main(String[] args) {
		TreeNode root = null;
        int[] keys = { 15, 10, 20, 8, 12, 16 };
 
        for (int key: keys) {
            root = insert(root, key);
        }
 
        root = deleteNode(root, 16);
        inorder(root);

	}

}
