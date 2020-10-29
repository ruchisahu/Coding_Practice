import java.util.*;

public class copyRandomList {
	



// Definition for a Node.

	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }

		public Node(int val2, Node next2, Object object) {
			
			// TODO Auto-generated constructor stub
		}
	}
	

	class Solution {
	    public Node copyRandomList(Node head) {
	        if (head == null)
	            return null;
	  
	  Map<Node,Node> map = new HashMap<Node,Node>();
	  
	  // loop 1. copy all the nodes
	  Node node = head;
	  while (node != null) {
	    map.put(node, new Node(node.val));
	    node = node.next;
	  }
	  
	  // loop 2. assign next and random pointers
	  node = head;
	  while (node != null) {
	    map.get(node).next = map.get(node.next);
	    map.get(node).random = map.get(node.random);
	    node = node.next;
	  }
	  
	  return map.get(head);
	    }
	}
////
	 public Node copyRandomList1(Node head) {
	        if (head == null) return null;
	        Node cur = head;
	        while (cur != null) {
	            Node next = cur.next;
	            cur.next = new Node(cur.val, next, null);
	            cur = next;
	        }
	        cur = head;
	        while (cur != null) {
	            if (cur.random != null)
	                cur.next.random = cur.random.next;
	            cur = cur.next.next;
	        }
	        cur = head;
	        Node copyHead = head.next;
	        while (cur != null) {
	            Node next = cur.next.next;
	            Node copy = cur.next;
	            cur.next = next;
	            if (next != null)
	                copy.next = next.next;
	            cur = next;
	        }
	        return copyHead;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
