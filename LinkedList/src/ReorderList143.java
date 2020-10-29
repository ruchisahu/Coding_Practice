//https://leetcode.com/problems/reorder-list/
//Given 1->2->3->4, reorder it to 1->4->2->3.
public class ReorderList143 {
public static void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        ListNode head1=head;
        ListNode prev=null;
        while(fast!=null && fast.next!=null) {
        	prev=slow;
        	slow=slow.next;
        	fast=fast.next.next;
        }
        prev.next=null;
        ListNode head2=reverse(slow);
        merge(head1,head2);
        PrintList.printListNode(head1);
        
    }

	private static void merge(ListNode nodePtr1, ListNode nodePtr2) {
		while(nodePtr1 != null && nodePtr2 != null) {
            ListNode temp1 = nodePtr1.next;
            nodePtr1.next = nodePtr2;
            ListNode temp2 = nodePtr2.next;
            nodePtr2.next = temp1;
            nodePtr1 = nodePtr1.next.next;
            nodePtr2 = temp2;
		}
	
}

	private static ListNode reverse(ListNode head) {
		ListNode prev=null;
		ListNode curr=head;
		ListNode next=null;
		while(curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		
	
	return prev;
}

	public static void main(String[] args) {
		ListNode head=SampleList.Reorder();
		reorderList(head);
		

	}

}
