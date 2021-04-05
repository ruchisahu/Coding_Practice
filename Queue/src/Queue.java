
public interface Queue<T> {
	public int size();
	public void offer(T elem);
	public T poll();
	public boolean isEmpty();

}
