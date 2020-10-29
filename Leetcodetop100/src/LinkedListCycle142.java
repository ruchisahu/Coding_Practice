
public class LinkedListCycle142 {
	
	 public static ListNode detectCycle(ListNode head) {
		 ListNode slow = head, fast = head;
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (slow == fast) {
					while (head != slow) {
						head = head.next;
						slow = slow.next;
					}
					return slow;				
				}
			}			
			return null;
		
	    }

	public static void main(String[] args) {
		ListNode evenList = ListSample.createEvenNodeList();

	     ListNode result = detectCycle( evenList ) ;

	PrintList.printListNode( result );

	}

}
