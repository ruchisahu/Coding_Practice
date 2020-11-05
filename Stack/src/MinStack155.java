import java.util.Stack;

public class MinStack155 {
    /** initialize your data structure here. */
	int min=Integer.MAX_VALUE;
	Stack<Integer> stack=new Stack<Integer>();
    public MinStack155() {
        
    }
    
    public void push(int x) {
        if(x<min) {
        	min=x;
        	stack.push(min);
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop()==min)
        	min=stack.pop();
    }
    
    public int top() {
		return stack.peek();
        
    }
    
    public int getMin() {
		return min;
        
    }


	public static void main(String[] args) {
		MinStack155 minStack = new MinStack155();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top();    // return 0
		minStack.getMin(); // return -2

	}

}
