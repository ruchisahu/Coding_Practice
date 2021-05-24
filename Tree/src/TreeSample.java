
public class TreeSample {
	public static TreeNode createTwoNodesTree()

	 {

	  TreeNode node0 = new TreeNode(0);

	  TreeNode node1 = new TreeNode(1);

	  node0.left = node1;

	  return node0;

	 }

	 

	 public static TreeNode createCompleteTree()

	 {  

	  TreeNode node0 = new TreeNode( 0 );

	  TreeNode node1 = new TreeNode( 1 );

	  TreeNode node2 = new TreeNode( 2 );

	  TreeNode node3 = new TreeNode( 3 );

	  TreeNode node4 = new TreeNode( 4 );



	  node0.left = node1;

	  node0.right = node2;

	  node1.left = node3;

	  node1.right = node4;

	  

	  return node0;

	 }

	 

	 public static TreeNode createFlattenedTree()

	 {

	  TreeNode node0 = new TreeNode( 0 );

	  TreeNode node1 = new TreeNode( 1 );

	  TreeNode node2 = new TreeNode( 2 );

	  TreeNode node3 = new TreeNode( 3 );

	  TreeNode node4 = new TreeNode( 4 );

	  

	  node0.left = node1;

	  node1.left = node2;

	  node2.left = node3;

	  node3.left = node4;

	  

	  return node0;

	 }



	 public static TreeNode createArbitraryTree()

	 {

	  TreeNode node0 = new TreeNode( 0 );

	  TreeNode node1 = new TreeNode( 1 );

	  TreeNode node2 = new TreeNode( 2 );

	  TreeNode node3 = new TreeNode( 3 );

	  TreeNode node4 = new TreeNode( 4 );

	  TreeNode node5 = new TreeNode( 5 );



	  node0.left = node1;

	  node0.right = node2;

	  node1.right = node3;

	  node2.left = node4;

	  node2.right = node5;

	  

	  return node0;

	 }

	  public static TreeNode createbstTree()

	 {

	  TreeNode node0 = new TreeNode( 5 );

	  TreeNode node1 = new TreeNode( 3 );

	  TreeNode node2 = new TreeNode( 10 );

	  TreeNode node3 = new TreeNode( 4 );

	  TreeNode node4 = new TreeNode( 6 );

	  TreeNode node5 = new TreeNode( 17 );



	  node0.left = node1;

	  node0.right = node2;

	  node1.right = node3;

	  node2.left = node4;

	  node2.right = node5;

	  

	  return node0;

	 }
	  public static TreeNode SecondMinimum() {
		  TreeNode node0 = new TreeNode( 2 );

		  TreeNode node1 = new TreeNode( 2 );

		  TreeNode node2 = new TreeNode( 5 );

		  TreeNode node3 = new TreeNode( 5 );

		  TreeNode node4 = new TreeNode( 7 );

		 

		  node0.left = node1;

		  node0.right = node2;

		  node2.right = node4;

		  node2.left = node3;

		  
		return node0;
		  
	  }
	  //[4,2,6,1,3,5,7]
	  public static TreeNode splitTree776()	 {

		  TreeNode node0 = new TreeNode( 4 );
		  TreeNode node1 = new TreeNode( 2 );
		  TreeNode node2 = new TreeNode( 6 );
		  TreeNode node3 = new TreeNode( 1 );
		  TreeNode node4 = new TreeNode( 3 );
		  TreeNode node5 = new TreeNode( 5 );
		  TreeNode node6 = new TreeNode( 7 );

		  node0.left = node1;   
		  node0.right = node2;   //2
		  node1.left = node3;  //6
		  node1.right = node4;  

		  node2.right = node6;   
		  
		  node2.left=node5;
		  

		  

		  return node0;

		 }
	  //[4,2,6,1,3,5,7]
	  public static TreeNode createbstTree652()

		 {

		  TreeNode node0 = new TreeNode( 1 );

		  TreeNode node1 = new TreeNode( 2 );

		  TreeNode node2 = new TreeNode( 3 );

		  TreeNode node3 = new TreeNode( 4 );

		  TreeNode node4 = new TreeNode( 2 );

		  TreeNode node5 = new TreeNode( 4 );
		  
		  TreeNode node6 = new TreeNode( 4 );
		  node0.left = node1;   //2
		  node0.right = node2;   //3

		  node1.left = node3;  //4

		  node2.left = node4;  //2

		//  node2.right = node5;   //4
		  
		  node4.left=node6;
	
 return node0;

		 }
	  
	  //sample for 865: smallest subtree with deepest nodes
	  public static TreeNode deepestNode()

		 {

		  TreeNode node0 = new TreeNode( 3 );

		  TreeNode node1 = new TreeNode( 5 );

		  TreeNode node2 = new TreeNode( 1 );

		  TreeNode node3 = new TreeNode( 6 );

		  TreeNode node4 = new TreeNode( 2 );

		  TreeNode node5 = new TreeNode( 0 );
		  TreeNode node6 = new TreeNode( 8 );
		  
		  TreeNode node7 = new TreeNode( 7 );
		  TreeNode node8 = new TreeNode( 4 );



		  node0.left = node1;  //5

		  node0.right = node2;  //1

		  node1.right = node4;

		  node1.left = node3;

		  node2.right = node5;
		  
		  node2.left = node6;
		  
          node4.right = node8;
		  
		  node4.left = node7;

		  

		  return node0;

		 }

	}