
public class ConvertSortedListtoBST109 {
	public static TreeNode sortedListToBST(ListNode head) {
	    if(head==null) return null;
	    return toBST(head,null);
	}
	public static TreeNode toBST(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail) return null;
	    
	    while(fast!=tail && fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode thead = new TreeNode(slow.val);
	    thead.left = toBST(head,slow);
	    thead.right = toBST(slow.next,tail);
	    return thead;
	
    }

	public static void main(String[] args) {
		ListNode l1=new ListNode(-10); 
		ListNode l2=new ListNode(-3); 
		ListNode l3=new ListNode(0); 
		ListNode l4=new ListNode(5); 
		ListNode l5=new ListNode(9); 
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		l5.next=null;
		TreeNode root=sortedListToBST(l1);
		PrintTree.TraversalIter(root);
		
		

	}

}
