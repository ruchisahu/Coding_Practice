import java.util.List;

public class TreeNode1 {
	
	    public int val;
	    public List<TreeNode1> children;
	    public TreeNode1() {}
	    
	    public TreeNode1(int _val) { val = _val; }
	    public TreeNode1(int _val,List<TreeNode1> _children) {
	        val = _val;
	        children = _children;
	    }
	};