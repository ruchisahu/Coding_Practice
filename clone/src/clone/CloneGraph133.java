package clone;

import java.util.*;
//https://leetcode.com/problems/clone-graph/

public class CloneGraph133 {
	public Node cloneGraph(Node node) 
    {
      return helper( node, new HashMap<>());
    }
	 private Node helper(Node node, Map<Node, Node> map)
	    {
	        if(node == null) {
	            return null;
	        }
	        if(map.containsKey(node))return map.get(node);
	        Node clone=new Node();
	        clone.val=node.val;
	        map.put(node, clone);
	        if(node.neighbors==null)return clone;
	        List<Node> neighbours=new ArrayList<>();
	        
	        for(Node neigh:node.neighbors) {
	        	neighbours.add(helper(neigh,map));
	        }
	        clone.neighbors=neighbours;
			return clone;
	    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};

}
