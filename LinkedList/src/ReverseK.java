
class ReverseK {

    public static ListNode reverseK(ListNode head, int k) {
        // TODO: Write your code here
        if (head == null || k <= 1) return head;
        ListNode prev = null, curr = head;
        ListNode start = prev, end = curr;
        while (true) {
            start = prev;
            end = curr;
            for (int i = 0; i < k && curr != null; i++) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            if (start != null) start.next = prev;
            else head = prev;

            end.next = curr;
            prev = end;
            if (curr == null) break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseK.reverseK(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}