import java.util.Stack;

public class QueueusingStacks {
	 /** Initialize your data structure here. */
	Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();
    public QueueusingStacks () {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	while(!s2.isEmpty()) {
    		s1.push(s2.pop());
    	}
		s2.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
		return s2.pop();
        
    }
    
    /** Get the front element. */
    public int peek() {
    	while(!s1.isEmpty()) {
    		s2.push(s1.pop());
    	}
		return s2.pop();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
		return false;
        
    }

	public static void main(String[] args) {
		QueueusingStacks q=new QueueusingStacks();
		for(int i=1;i<5;i++) {
			q.push(i);
		}
		System.out.println(q.peek());
		System.out.println(q.pop());
		System.out.println(q.pop());
		

	}

}
