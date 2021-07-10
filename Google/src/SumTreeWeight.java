import java.util.*;

public class SumTreeWeight {
	class Node {
		int id; 
		int parent; 
		int weight; 
	   Node(int id, int parent, int weight) {
			this.id=id;
			this.parent=parent;
			this.weight=weight;
			
	} 
	}

	public void printSubTreeWeight(List<Node> nodes) {
		Node root = null; 
		HashMap<Integer, List<Node>> children = new HashMap<Integer, List<Node>>();
		for(Node node : nodes) {
			if(node.parent == 0)
				root = node;
			int parent = node.parent;
			if(!children.containsKey(parent))
				children.put(parent, new LinkedList<Node>());
			children.get(parent).add(node);
		}
		sumWeight(root, children);
	}

	private int sumWeight(Node node, HashMap<Integer, List<Node>> children) {
		int weight = node.weight;
		if(children.containsKey(node)) {
			for(Node child : children.get(node)) {
				weight += sumWeight(child, children);
			}
		}
		System.out.println("Weight for " + node.id + " is " + weight);
		return weight;
	}

	public static void main(String[] args) {
		SumTreeWeight n=new SumTreeWeight();
		List<Node> nodes=new ArrayList<Node>();
		nodes.add(new Node(10,30,1));
		nodes.add(new Node(30,0,10));
		nodes.add(new Node(20,30,2));
		nodes.add(new Node(50,40,3));
		nodes.add(new Node(40,30,4));
		n.printSubTreeWeight(nodes);

	}

	
	

}
