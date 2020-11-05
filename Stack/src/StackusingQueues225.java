import java.util.LinkedList;

public class StackusingQueues225 {
	 /** Initialize your data structure here. */
	LinkedList<Integer> stack=new LinkedList<Integer>();
	int size=0;
    public StackusingQueues225() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
        size++;
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	int y=stack.remove();
    	size--;
		return y;
        
    }
    
    /** Get the top element. */
    public int top() {
		return stack.peek();
        
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	return stack.isEmpty();
    }



	public static void main(String[] args) {
		StackusingQueues225 myStack = new StackusingQueues225();
    	myStack.push(1);
    	myStack.push(2);
    	myStack.top(); // return 2
    	myStack.pop(); // return 2
    	myStack.empty(); // return False

	}

}
