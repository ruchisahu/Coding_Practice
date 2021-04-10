package test;
class inOrderSuccessor{
class Node {

	int data;
	Node left, right, parent;

	Node(int d)
	{
		data = d;
		left = right = parent = null;
	}
}

	public static Node inOrderSuccessor(Node root, Node n)
	{
		return n;

		
	}

	
	// Driver program to test above functions
	public static void main(String[] args)
	{
		Node root;
		root = new Node(6);
        root. left = new Node(4);
        root. right = new Node(10);
        root. left. left = new Node(1);
        root. left. right = new Node(5);
        root. right. right = new Node(12);
        root. right. left = new Node(8);
        root. right. left. left = new Node(7);
        root. right. left. right = new Node(9);
		inOrderSuccessor(root, 8);
		
	}
}


