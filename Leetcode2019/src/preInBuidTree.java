
 class BTNode { 
    char data; 
    BTNode left, right; 
  
    BTNode(char item) 
    { 
        data = item; 
        left = right = null; 
    } 
}


public class preInBuidTree { 
		BTNode root; 
		static int preIndex = 0; 

		BTNode buildTree(char in[], char pre[], int inStrt, int inEnd) 
		{ 
			if (inStrt > inEnd) 
				return null; 
			BTNode tNode = new BTNode(pre[preIndex++]); 

			if (inStrt == inEnd) 
				return tNode; 
			int inIndex = search(in, inStrt, inEnd, tNode.data); 

			tNode.left = buildTree(in, pre, inStrt, inIndex - 1); 
			tNode.right = buildTree(in, pre, inIndex + 1, inEnd); 
			return tNode; 
		} 
		int search(char arr[], int strt, int end, char value) 
		{ 
			int i; 
			for (i = strt; i <= end; i++) { 
				if (arr[i] == value) 
					return i; 
			} 
			return i; 
		} 

		void printInorder(BTNode node) 
		{ 
			if (node == null) 
				return; 
			printInorder(node.left); 
			System.out.print(node.data + " "); 
			printInorder(node.right); 
		} 

		// driver program to test above functions 
		public static void main(String args[]) 
		{ 
			preInBuidTree tree = new preInBuidTree(); 
			char in[] = new char[] { 'D', 'B', 'E', 'A', 'F', 'C' }; 
			char pre[] = new char[] { 'A', 'B', 'D', 'E', 'C', 'F' }; 
			int len = in.length; 
			BTNode root = tree.buildTree(in, pre, 0, len - 1); 

			System.out.println("Inorder traversal of constructed tree is : "); 
			tree.printInorder(root); 
		} 
	} 

