import java.util.*;

public class CloneGraph133 {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	 public Node cloneGraph(Node node) {
		return node;
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
