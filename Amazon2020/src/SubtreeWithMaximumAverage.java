import java.util.*;

public class SubtreeWithMaximumAverage
{
	
	double max = Integer.MIN_VALUE;
	TreeNode1 maxNode = null;
//working
	public TreeNode1 getMaximumAverage(TreeNode1 root) {
	    if (root == null) return null;
	    helper(root);
	    return maxNode;
	}

	private double[] helper(TreeNode1 root)
	{
	    if (root == null) return new double[] {0, 0};

	    double curTotal = root.val;
	    double count = 1;
	    System.out.println(root.val);
	    for (TreeNode1 child : root.children) {
	        double[] cur = helper(child);
	        curTotal += cur[0];
	        count += cur[1];
	    }   
	    
	   // System.out.println(avg);
	    double avg = curTotal / count;
	    if (count > 1 && avg > max) { //taking "at least 1 child" into account
	    	//if (count > 1 && avg > max) {  variation with taking 1 node also
	        max = avg;
	        maxNode = root;
	    }
	    System.out.println(avg);
	    return new double[] {curTotal, count};
	}
	
	//sol2
	 public double maximumAverageSubtree(TreeNode root) {

	        return helper(root)[2];

	    }

	    private double[] helper(TreeNode n) {

	        if (n == null)  // base case.

	            return new double[]{0, 0, 0}; // sum, count  & average of nodes

	        double[] l = helper(n.left), r = helper(n.right); // recurse to children.

	        double child = Math.max(l[2], r[2]); // larger of the children.

	        double sum = n.val + l[0] + r[0], cnt = 1 + l[1] + r[1]; // sum & count of subtree rooted at n.

	        double maxOfThree = Math.max(child, sum  / cnt); // largest out of n and its children.

	        return new double[]{sum, cnt, maxOfThree}; 

	    }



	//Analysis:	Time & space: O(n), n is the # of nodes in the tree.
	    
	    
//sol3
	    static int maxAvg1 = 0;
	       public static  int maximumAverageSubtree1(TreeNode root) {
	            int cnt = 0;
	            getSum(root, cnt);
	            return maxAvg1;
	            
	        }
	        
	    
	       public static int getSum(TreeNode root, int  cnt) {
	            if (root == null) return 0;
	            int left_cnt = 0;
	            int right_cnt = 0;
	            int left = getSum(root.left, left_cnt);
	            int right = getSum(root.right, right_cnt);
	            int sum = left + right + root.val;
	            cnt = left_cnt + right_cnt + 1;
	            maxAvg1 = Math.max(maxAvg1, sum / cnt);
	            return sum;
	        }
	        double maxAvg = 0.0;

	 public static void main(String[] args) 
	 {
	        // Input:
	        //              20
	        //            /   \
	        //          12     18
	        //       /  |  \   / \
	        //     11   2   3 15  8
	        TreeNode1 left = new TreeNode1(12);
	        left.children = Arrays.asList(new TreeNode1(11), new TreeNode1(2), new TreeNode1(3));

	        TreeNode1 right = new TreeNode1(18);
	        right.children = Arrays.asList(new TreeNode1(15), new TreeNode1(8));
	        
	        TreeNode1 root = new TreeNode1(20);
	        root.children = Arrays.asList(left, right);

	     //   test(root); // output: 18
	    }
	    
	    private static void test(TreeNode1 root) {
	    	TreeNode1 maxNode = new SubtreeWithMaximumAverage().getMaximumAverage(root);
	        System.out.println("Max Average: " + maxNode.val);
	    }
	}