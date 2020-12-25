
public class MinStack2 {
	private class Node {
        int val;
        Node next;
        int min;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    Node head;
public MinStack2() {
        
    }
    
    public void push(int x) {
        
    }
    
    public void pop() {
        
    }
    
    public int top() {
		return 0;
        
    }
    
    public int getMin() {
		return 0;
        
    }


	public static void main(String[] args) {
		MinStack2 minStack = new MinStack2();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2

	}

}
