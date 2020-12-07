
public class OrderedPairClass<K,V> implements OrderedPair<K,V> {
	private K key;
    private V value;

    public OrderedPairClass(K key, V value) {
	this.key = key;
	this.value = value;
    }
    public void setKey(K key) { this.key = key; }
    public void setValue(V value) { this.value = value; }

    public K getKey()	{ return key; }
    public V getValue() { return value; }


	public static void main(String[] args) {
		OrderedPairClass<String,Integer> p1=new OrderedPairClass<>("Even",8);
		System.out.println(p1.getKey());
		
		OrderedPairClass<String,Box<Integer>> p2=new OrderedPairClass<>("Even",new Box<Integer>(3));
		System.out.println(p2.getValue().get());
		

	}

	

}
