//https://docs.oracle.com/javase/tutorial/java/generics/boundedTypeParams.html
public class countGreaterThan {
	//can not compare : greater than operator (>) applies only to primitive types such as short, int, double, long, float, byte, and char. 
	/*
	public static <T> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e > elem)  // compiler error
	            ++count;
	    return count;
	}
	*/
	public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
	    int count = 0;
	    for (T e : anArray)
	        if (e.compareTo(elem) > 0)
	            ++count;
	    return count;
	}
	public static void main(String[] args) {
		Integer[] number = new Integer[] {12,0,15,18,4};
	    int a = countGreaterThan(number, 10);
	    System.out.println(" greater than 10 is: "+a);
	}

}
