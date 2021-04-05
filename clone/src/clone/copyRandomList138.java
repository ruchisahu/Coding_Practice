package clone;
//https://leetcode.com/problems/copy-list-with-random-pointer/
import java.util.HashMap;
import java.util.Map;

public class copyRandomList138 {
	 Map<Node, Node> map = new HashMap<>();
	    public Node copyRandomList(Node head) {
	        if(head == null){
	            return head;
	        }
	        if(map.get(head) != null){
	            return map.get(head);
	        }
	        Node nh = new Node(head.val);
	        map.put(head, nh);
	        nh.next = copyRandomList(head.next);
	        nh.random = copyRandomList(head.random);
	        return nh;
	    }
	    class Node {
	        int val;
	        Node next;
	        Node random;

	        public Node(int val) {
	            this.val = val;
	            this.next = null;
	            this.random = null;
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
