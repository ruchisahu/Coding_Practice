
public class InsertionSort {
	ListNode head; 
    ListNode sorted;

		// function to sort a singly linked list using insertion sort 
    public static ListNode insertionSortList(ListNode head) {
		if( head == null ){
			return head;
		}
		
		ListNode helper = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode pre = helper; //insert node between pre and pre.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( pre.next != null && pre.next.val < cur.val ){
				pre = pre.next;
			}
			//insert between pre and pre.next
			cur.next = pre.next;
			pre.next = cur;
			pre = helper;
			cur = next;
		}
		
		return helper.next;
	} 

		static /* Function to print linked list */
		void printlist(ListNode head) 
		{ 
			while (head != null) 
			{ 
				System.out.print(head.val + " "); 
				head = head.next; 
			} 
		} 
		
		// Driver program to test above functions 
		public static void main(String[] args) 
		{ 
			ListNode head=SampleList.test1();
			
			System.out.println("Linked List before Sorting.."); 
			printlist(head); 
			ListNode h=insertionSortList(head); 
			System.out.println("\nLinkedList After sorting"); 
			PrintList.printListNode(h);
			printlist(head); 
		} 
	} 

	