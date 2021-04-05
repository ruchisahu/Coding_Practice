
public class ArrayQueue<T> implements Queue<T> {
	private Object[] data;
	private int front;
	private int rear;
	public ArrayQueue(int capacity) {
	    // ArrayQueue maximum size is data.length - 1.
	    data = new Object[capacity + 1];
	    front = 0;
	    rear = 0;
	  }


	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void offer(T elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	 public boolean isFull() {
		    return (front + data.length - rear) % data.length == 1;
		  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
