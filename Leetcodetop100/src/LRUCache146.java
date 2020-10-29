import java.util.*;

public class LRUCache146 {
	Node head = new Node(0, 0), tail = new Node(0, 0);
	  Map<Integer, Node> map = new HashMap();
	  int capacity;
	  
	  public LRUCache146(int _capacity) {
	    capacity = _capacity;
	    head.next = tail;
	    tail.prev = head;
	  }

	  public int get(int key) {
		  
	    if(map.containsKey(key)) {
	      Node node = map.get(key);
	      remove(node);
	      insert(node);
	      return node.value;
	    } else {
	      return -1;
	    }
	  }

	  public void put(int key, int value) {
	    if(map.containsKey(key)) {
	      remove(map.get(key));
	    }
	    if(map.size() == capacity) {
	      remove(tail.prev);
	    }
	    insert(new Node(key, value));
	  }
	  
	  private void remove(Node node) {
	    map.remove(node.key);
	    node.prev.next = node.next;
	    node.next.prev = node.prev;
	  }
	  
	  private void insert(Node node){
	    map.put(node.key, node);
	    Node headNext = head.next;
	    head.next = node;
	    node.prev = head;
	    headNext.prev = node;
	    node.next = headNext;
	  }
	  
	  class Node{
	    Node prev, next;
	    int key, value;
	    Node(int _key, int _value) {
	      key = _key;
	      value = _value;
	    }
	  }
	
	public static void main(String[] args) {
		LRUCache146 cache = new LRUCache146( 3);
		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4

	}

}
