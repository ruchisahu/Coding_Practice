
	import java.util.Stack; 

	/* Class containing left and right child of 
	current node and key value*/
	class Node2 
	{ 
		int data; 
		Node2 left, right; 

		public Node2(int item) 
		{ 
			data = item; 
			left = right = null; 
		} 
	} 

	
	class preorder
	{ 
		private Node2 root;




		void preorder()
		{
			if(root==null)
				return;
			Stack<Node2> s=new Stack<Node2>();
			s.add(root);
			while(!s.isEmpty())
			{
				Node2 curr=s.pop();
				if(curr!=null)
				{
				s.push(curr.right);
				s.push(curr.left);
				System.out.print(curr.data + " ");
				}
			}
			
			
		}

				
	

		public static void main(String args[]) 
		{ 

			/* creating a binary tree and entering 
			the nodes */
			preorder tree = new preorder(); 
			tree.root = new Node2(1); 
			tree.root.left = new Node2(2); 
			tree.root.right = new Node2(3); 
			tree.root.left.left = new Node2(4); 
			tree.root.left.right = new Node2(5); 
			tree.preorder(); 
		} 
	} 


