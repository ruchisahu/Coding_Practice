import java.util.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {
	LinkedList<T> list = new LinkedList<T>();

	  public LinkedListQueue() {}

	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void offer(T elem) {
		list.addLast(elem);
		
	}

	@Override
	public T poll() {
		if (isEmpty()) throw new RuntimeException("Queue Empty");
		return list.removeFirst();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size() == 0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
