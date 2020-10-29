//https://leetcode.com/discuss/interview-question/376375
/*
 * Given a list of unique integers nums, construct a BST from it (you need to insert nodes one-by-one with the given order to get the BST) and find the distance between two nodes node1 and node2. Distance is the number of edges between two nodes. If any of the given nodes does not appear in the BST, return -1.

Example 1:

Input: nums = [2, 1, 3], node1 = 1, node2 = 3
Output: 2
Explanation:
     2
   /   \
  1     3
 */
public class DistanceBetween_nodesInBST {
	private TreeNode buildBST(int[] nums, int node1, int node2) {

	    TreeNode root = null;

	    boolean found1 = false;

	    boolean found2 = false;

	    for (int val : nums) {

	        if (val == node1) found1 = true;

	        if (val == node2) found2 = true;

	        

	        TreeNode node = new TreeNode(val);

	        if (root == null) {

	            root = node;

	            continue;

	        }

	        addToBST(root, node);

	    }

	    if (!found1 || !found2) return null;

	    return root;

	}



	private void addToBST(TreeNode root, TreeNode node) {

	    for (TreeNode curr = root; true; ) {

	        if (curr.val > node.val) {

	            if (curr.left == null) {

	                curr.left = node;

	                break;

	            } else {

	                curr = curr.left;

	            }

	        } else {

	            if (curr.right == null) {

	                curr.right = node;

	                break;

	            } else {

	                curr = curr.right;

	            }

	        }

	    }

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
