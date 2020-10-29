import java.util.Stack;

public class Inorder 
{
Node2 root;
void inorder()
{
	if(root==null)
		return;
	Stack < Node2 > stack = new Stack < > ();
    Node2 curr = root;
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        System.out.println(curr.data);
        curr = curr.right;
    }
	
	
}


	public static void main(String args[]) 
	{ 
		
		
		Inorder tree = new Inorder(); 
		tree.root = new Node2(1); 
		tree.root.left = new Node2(2); 
		tree.root.right = new Node2(3); 
		tree.root.left.left = new Node2(4); 
		tree.root.left.right = new Node2(5); 
		tree.inorder(); 
	} 

}
