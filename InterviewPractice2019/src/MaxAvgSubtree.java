import java.util.List;

public class MaxAvgSubtree {
	public class Node {
	    public int val;
	    public List<Node> children;
	    public Node() {}
	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	double max = 0;
	Node res = null;
	public int[] computeAvg(Node root){
	    if(root == null) return new int[]{0, 0};
	    int val = root.val, count = 1;
	    for(Node child: root.children){
	        int[] arr = computeAvg(child);
	        val += arr[0]; count += arr[1];
	    }
	    if(count > 1 && (res == null || val / (0.0 + count) > max)){
	        res = root; 
	        max = val / (0.0 + count);
	    }
	    return new int[]{val, count};
	}
	public Node subtreeWithMaximumAverage(Node root){
	    if(root == null) return res;
	    computeAvg(root);
	    return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
