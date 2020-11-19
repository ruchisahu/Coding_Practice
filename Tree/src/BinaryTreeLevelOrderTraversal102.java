import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
	 public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> result=new ArrayList<List<Integer>>();
		 if(root==null)return result;
		 Queue<TreeNode> q=new LinkedList<TreeNode>();
		 q.add(root);
		 while(!q.isEmpty()) {
			 int size=q.size();
			 List<Integer> temp=new ArrayList<Integer>();
			 for(int i=0;i<size;i++) {
				 TreeNode n=q.poll();
				 temp.add(n.val);
				 if(n.left!=null) {
					 q.add(n.left);
				 }
				 if(n.right!=null) {
					 q.add(n.right);
				 }

			 }
			 result.add(temp);
		 }
		 return result;
	        
	    }
	 public static void printResult(List<List<Integer>> result){
			int depth = 0;
			for(List<Integer> entry : result) {
				Iterator<Integer> i = entry.listIterator();
				System.out.print("Link list at depth " + depth + ":");
				while(i.hasNext()){
					System.out.print(" " + i.next());
				}
				System.out.println();
				depth++;
			}
		}

	public static void main(String[] args) {
		TreeSample T=new TreeSample();
		TreeNode root=T.createbstTree();
		List<List<Integer>> list= levelOrder(root);
		 printResult(list);
		

	}

}
