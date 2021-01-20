package test;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Stack1<E> {

     Deque<E> deque = new ArrayDeque<>();

       public boolean isEmpty() {
        return deque.isEmpty();
    }

    public void push(E item) {
        deque.addFirst(item);
    }

    public E pop() {
    	 // if deque is not empty remove an element from the front of deque
        if (!deque.isEmpty()) {
            return deque.removeFirst();
        }
		return null;
        
    }

    public int getSize() {
        return deque.size();
    }


	public static void main(String[] args) {
		//deque = new LinkedList<>();
        // Example
		Stack1<Integer> s=new Stack1<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.pop());
        System.out.println(s.getSize());
    }

	

}
