import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements StackG<T> {
	private int size;
	private int capacity;
	private Object[] data;
	
	public ArrayStack(int capacity) {
		this.capacity=capacity;
		data=new Object[capacity];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		if(size==capacity)increaseCapacity();
		
		data[size++]=elem;
		
	}

	private void increaseCapacity() {
		capacity=capacity*2;
		data=Arrays.copyOf(data,capacity);
		
	}

	@Override
	public T pop() {
		if(isEmpty())throw new EmptyStackException();
		T elem=(T) data[--size];
		data[size]=null;
		return elem;
	}

	@Override
	public T peek() {
		if (isEmpty()) throw new EmptyStackException();
	    return (T) data[size - 1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
