
public class Merge2list {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(0);
		ListNode curr=head;
		while(l1!=null && l2!=null) {
			if(l1.val>l2.val) {
				curr.next=l2;
				l2=l2.next;
			}
			else {
				curr.next=l1;
				l1=l1.next;
			}
			curr=curr.next;
		}
		curr.next=(l1!=null)?l1:l2;
		return head.next;
	}
	static void printlist(ListNode head) 
	{ 
		while (head != null) 
		{ 
			System.out.print(head.val + " "); 
			head = head.next; 
		} 
	} 

	public static void main(String[] args) {
		ListNode l1=SampleList.createEvenNodeList();
		ListNode l2=SampleList.createOddNodeList();	
		ListNode head=mergeTwoLists(l1,l2);
		printlist(head); 
	}
}
