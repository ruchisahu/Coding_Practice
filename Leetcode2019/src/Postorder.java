import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Postorder 
{
	Node2 root;
	 List<Integer> list = new ArrayList<>();
	 public List<Integer> postorder()
	{
		
		if(root == null)
			return list;
		
        Stack<Node2> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) 
        {
            Node2 curr = stack.pop();
            list.add(0,curr.data);
            if(curr.left!=null) {
              stack.push(curr.left);
            }
            if(curr.right!=null) {
               stack.push(curr.right); 
            }
        }
        return list;
		
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
