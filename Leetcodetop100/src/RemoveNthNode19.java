
public class RemoveNthNode19 {
	 public static ListNode removeNthFromEnd(ListNode head, int n)
	    {
		 ListNode res = new ListNode(0), slow = res, fast = res;
	        slow.next = head;
	        for(int i=0; i<n; i++) {
	            fast = fast.next;
	        }
	        while(fast.next!=null) {
	            fast = fast.next;
	            slow = slow.next;
	        }
	        slow.next = slow.next.next;
	        return res.next;
	    }

	public static void main(String[] args) {
		ListNode head = ListSample.createEvenNodeList();
		ListNode result=removeNthFromEnd(head, 2);
		PrintList.printListNode( result );
		

	}

}
