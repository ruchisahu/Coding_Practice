public class ReverseK {
 
    private ListNode1 head;
 
    public void add(int data) {
        if (head == null) {
            head = new ListNode1(data);
            return;
        }
 
        ListNode1 n = new ListNode1(data);
        ListNode1 tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = n;
    }
 
    public void printList() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        ListNode1 tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data + " -> ");
            tmp = tmp.next;
        }
        System.out.println("null");
    }
 
    public void reverseKAlternateNodes(int k) {
        if (head == null || head.next == null || k < 2) {
            return;
        }
        head = reverseKAlternateNodes(head, k);
    }
 
    // Reverse alternate k nodes
    public ListNode1 reverseKAlternateNodes(ListNode1 head, int k) {
        if (head == null || head.next == null || k < 2) {
            return head;
        }
 
        // get k+1th node
        ListNode1 temp = head;
        int i = 0;
        while (i < k && temp != null) {
            temp = temp.next;
            i++;
        }
 
        // reverse nodes upto k nodes traversed previously
        head = reverseKNodes(head, k);
        ListNode1 next = head;
        while (next.next != null) {
            next = next.next;
        }
        next.next = temp;
 
        // Traverse next k nodes
        i = 0;
        ListNode1 prev = null;
        while (i < k && temp != null) {
            prev = temp;
            temp = temp.next;
            i++;
        }
 
        if (temp != null) {
            prev.next = this.reverseKAlternateNodes(temp, k);
        }
 
        return head;
    }
 
    // Reverse k nodes starting from start node
    private ListNode1 reverseKNodes(ListNode1 start, int k) {
 
        if (start == null || k < 2) {
            return null;
        }
 
        ListNode1 prev = null;
        ListNode1 curr = start;
        ListNode1 next = null;
 
        int i = 1;
        while (curr.next != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }
        next = curr.next;
        curr.next = prev;
        return curr;
    }
 
    public static void main(String[] args) {
    	ReverseK list = new ReverseK();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.printList();
        list.reverseKAlternateNodes(4);
        list.printList();
    }
}
 
class ListNode1 {
 
    int data;
    ListNode1 next;
 
    public ListNode1(int data) {
        this.data = data;
    }
}
        