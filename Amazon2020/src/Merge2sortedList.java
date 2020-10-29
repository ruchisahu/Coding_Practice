
public class Merge2sortedList {
	 public static ListNode mergeTwoLists(ListNode a, ListNode b) {
		 ListNode head = new ListNode(0);
	        ListNode curr = head;
	        while(a!=null && b!=null)
	        {
	            
	            if(a.val > b.val)
	            {
	               curr.next = b;
	                b = b.next;
	            }
	            else
	            {
	               curr.next = a;
	                a = a.next;
	            }
	          //  curr.next=c;
	            curr=curr.next;
	        }
	        
	        curr.next = (a != null) ? a : b;
	        
	        
	        return head.next;
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
