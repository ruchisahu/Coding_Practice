
public class Pair<T1, T2> {
T1 x;
T2 y;
	Pair(T1 x,T2 y){
		this.x=x;
		this.y=y;
	}
	public T2 getValue() {
		// TODO Auto-generated method stub
		return y;
	}
	public T1 getKey() {
		// TODO Auto-generated method stub
		return x;
	}
}
