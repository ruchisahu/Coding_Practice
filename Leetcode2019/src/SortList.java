
public class SortList
{
	public static ListNode sortList(ListNode head) {
	/*    if (head == null || head.next == null)
	      return head;
	        
	    // step 1. cut the list to two halves
	    ListNode prev = null, slow = head, fast = head;
	    
	    while (fast != null && fast.next != null) 
	    {
	      prev = slow;
	      slow = slow.next;
	      System.out.println("slow"+slow.val);
	      fast = fast.next.next;
	      //System.out.println("fast"+fast.val);
	    }
	    
	    prev.next = null;
	    PrintList.printListNode(head);
	    PrintList.printListNode(slow);
	    // step 2. sort each half
	    ListNode l1 = sortList(head);
	    ListNode l2 = sortList(slow);
	    
	    // step 3. merge l1 and l2
	    return merge(l1, l2);
	  }
	  
	  static ListNode merge(ListNode l1, ListNode l2)
	  {
	    ListNode l = new ListNode(0), p = l;
	    
	    while (l1 != null && l2 != null) {
	      if (l1.val < l2.val) {
	        p.next = l1;
	        l1 = l1.next;
	      } else 
	      {
	        p.next = l2;
	        l2 = l2.next;
	      
	      p = p.next;
	    }
	 
	    if (l1 != null)
	      p.next = l1;
	    
	    if (l2 != null)
	      p.next = l2;
	    
	    return l.next;
	  }

	


	public static void main(String[] args)
	{
		ListNode node1 = new ListNode( 7 );

	     ListNode node2 = new ListNode( 19 );

	   

	     ListNode node3 = new ListNode( 14 );

	     ListNode node4 = new ListNode( 30 );

	     node1.next = node2;

	     node2.next = node3;

	     node3.next = node4;
		
	     sortList(node1);
	     PrintList.printListNode(node1);
	     */
		return head;
	}

}