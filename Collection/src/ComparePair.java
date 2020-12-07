
public class ComparePair {
	public static<K,V> boolean compare(OrderedPairClass<K,V> p1,OrderedPairClass<K,V> p2 ) {
		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());}

	public static void main(String[] args) {
		OrderedPairClass<Integer, String> p1 = new OrderedPairClass<>(1, "apple");
		OrderedPairClass<Integer, String> p2 = new OrderedPairClass<>(2, "pear");
		boolean same=ComparePair.compare(p1, p2);
		System.out.println(same);

	}

}
