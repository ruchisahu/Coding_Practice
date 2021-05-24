import java.util.Deque;
import java.util.LinkedList;

public class MinMaxStack {
	private Deque<Integer> stack = new LinkedList<>();
    private Deque<Integer> minStack = new LinkedList<>();
    private Deque<Integer> maxStack = new LinkedList<>();
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek()>=x) minStack.push(x);
        if(maxStack.isEmpty() || maxStack.peek()<=x) maxStack.push(x);
    }
    
    public int pop() {
        int tmp = stack.pop();
        if(!minStack.isEmpty() && minStack.peek() == tmp) minStack.pop();
        if(!maxStack.isEmpty() && maxStack.peek() == tmp) maxStack.pop();
        return tmp;
    }
    public int peek() {
        return stack.peek();
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }
    public int getMin() {
        if(!minStack.isEmpty()) return minStack.peek();
        else return Integer.MAX_VALUE;
    }    
    public int getMax(){
        if(!maxStack.isEmpty()) return maxStack.peek();
        else return Integer.MIN_VALUE;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
