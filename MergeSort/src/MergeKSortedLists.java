import java.util.PriorityQueue;
import java.util.Queue;

class MergeKSortedLists {
		
	

	    public ListNode merge(ListNode[] lists) {
	        Queue<ListNode> queue = new PriorityQueue<>((a,b)-> a.value-b.value);
	        for (ListNode node: lists) {
	            if (node != null) queue.add(node);
	        }
	        ListNode result = null;
	        ListNode prev = null;
	        while (!queue.isEmpty()) {
	            ListNode curr = queue.poll();
	            if (prev == null) {
	                prev = curr;
	                result = curr;
	            } else {
	                prev.next = curr;
	                prev = prev.next;
	            }
	            if (curr.next != null) queue.add(curr.next);
	        }
	        return result;
	    }

	    public static void main(String[] args) {
	        ListNode l1 = new ListNode(2);
	        l1.next = new ListNode(6);
	        l1.next.next = new ListNode(8);

	        ListNode l2 = new ListNode(3);
	        l2.next = new ListNode(6);
	        l2.next.next = new ListNode(7);

	        ListNode l3 = new ListNode(1);
	        l3.next = new ListNode(3);
	        l3.next.next = new ListNode(4);
	        MergeKSortedLists m=new MergeKSortedLists();
	        ListNode result = m.merge(new ListNode[] { l1, l2, l3 });
	        System.out.print("Here are the elements form the merged list: ");
	        while (result != null) {
	            System.out.print(result.value + " ");
	            result = result.next;
	        }
	    }
	}

