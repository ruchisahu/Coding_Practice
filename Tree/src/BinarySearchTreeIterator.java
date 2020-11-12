import java.util.*;

//https://leetcode.com/problems/binary-search-tree-iterator/
public class BinarySearchTreeIterator {
    Queue<TreeNode> q=new LinkedList<TreeNode>();

    public BinarySearchTreeIterator(TreeNode root) {
        Traverse(root);
    }
    public void Traverse(TreeNode root){
        if(root==null)return;
        Traverse(root.left);
        q.add(root);
        Traverse(root.right);
    }
    /** @return the next smallest number */
    public int next() {
       return q.remove().val; 
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !q.isEmpty();
    }


	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		BinarySearchTreeIterator bst=new BinarySearchTreeIterator(root);
		System.out.println(bst.next());
		
		

	}

}
