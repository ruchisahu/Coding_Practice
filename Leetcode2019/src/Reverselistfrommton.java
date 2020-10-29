
public class Reverselistfrommton
{
	public ListNode reverseBetween(ListNode head, int m, int n)
	{
	    if(m==n) return head;
	 
	    ListNode prev = null;
	    ListNode first = new ListNode(0);
	    ListNode second = new ListNode(0);
	 
	    int i=0;
	    ListNode p = head;
	    while(p!=null)
	    {
	        i++;
	        if(i==m-1)
	        {
	            prev = p;
	        }
	 
	        if(i==m)
	        {
	            first.next = p;
	        }
	 
	        if(i==n){
	            second.next = p.next;
	            p.next = null;
	        }
	 
	        p= p.next;
	    }
	    if(first.next == null)
	        return head;
	 
	    // reverse list [m, n]    
	    ListNode p1 = first.next;
	    ListNode p2 = p1.next;
	    p1.next = second.next;
	 
	    while(p1!=null && p2!=null){
	        ListNode t = p2.next;
	        p2.next = p1;
	        p1 = p2;
	        p2 = t;
	    }
	 
	    //connect to previous part
	    if(prev!=null)
	        prev.next = p1;
	    else
	        return p1;
	 
	    return head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
