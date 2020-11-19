
public class MinimalBinarySearchTree {

	public static TreeNode CreateMinimalBST(int[] a) {
		
		return CreateMinimalBST(a,0,a.length);
		
	}
	public static TreeNode CreateMinimalBST(int[] a,int start, int end) {
		if(start>end) {
			return null;
		}
		int mid=(start +end)/2;
		TreeNode t=new TreeNode(a[mid]);
		t.left=CreateMinimalBST(a,start,mid-1);
		t.right=CreateMinimalBST(a,mid+1,start);
		return t;
		
	}

	public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		// We needed this code for other files, so check out the code in the library
		TreeNode root = CreateMinimalBST(array);
		System.out.println("Root? " + root.val);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
		BTreePrinter.printNode(root);
		

	}

}
