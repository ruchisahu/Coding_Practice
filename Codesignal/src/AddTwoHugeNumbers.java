
public class AddTwoHugeNumbers {
	// Singly-linked lists are already defined with this interface:
	 class ListNode<T> {
		 ListNode(T x) {
			 value = x;
		 }

		 T value;
		 ListNode<T> next;
	 }
	
	static ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
	   // ListNode<Integer> result =new ListNode<>(0);
		
	    ListNode<Integer> r = new ListNode<Integer>(0);
	        ListNode<Integer> head = r;
	        int carry = 0;
	        a = reverse(a);
	        b = reverse(b);
	        while (a != null || b != null) {
	            if (a != null) {
	                carry += a.value;
	                a = a.next;
	            }
	            if (b != null) {
	                carry += b.value;
	                b = b.next;
	            }
	            head.next = new ListNode<>(carry % 10000);
	            head = head.next;
	            carry = carry / 10000;
	        }
	        if (carry >= 1)
	            head.next = new ListNode<>(carry);

	        return reverse(r.next);
	    }

	    static ListNode<Integer> reverse(ListNode<Integer> head) {
	        ListNode<Integer> prev = null;
	        while (head != null) {
	            ListNode<Integer> temp = head.next;
	            head.next = prev;
	            prev = head;
	            head = temp;
	        }
	        return prev;
	    }

	public static void main(String[] args) {
		//a = [9876, 5432, 1999] and b = [1, 8001]

		ListNode<Integer> v1;

		ListNode<Integer> v2;
		ListNode<Integer> v3;
		ListNode<Integer> v4;
		ListNode<Integer> v5;

		v1 = new ListNode<>(9876);
		v2 = new ListNode<>(5432);
		v3 = new ListNode<>(1999);
		v4 = new ListNode<>(1);
		v5 = new ListNode<>(8001);
		

		v4.next = v5;
		
		
		System.out.println(addTwoHugeNumbers(v1, v4));
	}

}
