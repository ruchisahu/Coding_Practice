package Chap_10;

public class SinglyLinkedList {
	Node head;
	public void insertAtBeginning(int x) {
		Node newNode=new Node(x);
		newNode.next=head;
		head=newNode;
	}
	 public void insertAfter(Node prev, int x) {
		 if(prev==null) {
			 System.out.println("null");
			 return;
		 }
		 Node newNode=new Node(x);
		 newNode.next=prev.next;
		 prev.next=newNode;
		 
	 }
	 public void insertAtEnd(int data) {
		    Node new_node = new Node(data);

		    if (head == null) {
		      head = new Node(data);
		      return;
		    }

		    new_node.next = null;

		    Node last = head;
		    while (last.next != null)
		      last = last.next;

		    last.next = new_node;
		    return;
		  }
	 
	 void deleteNode(int position) {
		    if (head == null)
		      return;

		    Node node = head;

		    if (position == 0) {
		      head = node.next;
		      return;
		    }
		    // Find the key to be deleted
		    for (int i = 0; node != null && i < position - 1; i++)
		      node = node.next;

		    // If the key is not present
		    if (node == null || node.next == null)
		      return;

		    // Remove the node
		    Node next = node.next.next;

		    node.next = next;
		  }
	 public void printList() {
		    Node node = head;
		    while (node != null) {
		      System.out.print(node.val + " ");
		      node = node.next;
		    }
		  }


	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();

		    // Assign value values
		    linkedList.head = new Node(1);
		    Node second = new Node(2);
		    Node third = new Node(3);

		    
		    linkedList.head.next = second;
		    second.next = third;

		    // printing node-value
		    while (linkedList.head != null) {
		      System.out.print(linkedList.head.val + " ");
		      linkedList.head = linkedList.head.next;
		    }
		    SinglyLinkedList llist = new SinglyLinkedList();

		    llist.insertAtEnd(1);
		    llist.insertAtBeginning(2);
		    llist.insertAtBeginning(3);
		    llist.insertAtEnd(4);
		    llist.insertAfter(llist.head.next, 5);

		    System.out.println("Linked list: ");
		    llist.printList();

		    System.out.println("\nAfter deleting an element: ");
		    llist.deleteNode(3);
		    llist.printList();
	}

}
