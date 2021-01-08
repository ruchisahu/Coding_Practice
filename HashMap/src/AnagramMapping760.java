import java.util.*;

public class AnagramMapping760 {
	public static int[] anagramMappings(int[] A, int[] B) {
		int[] ans=new int[A.length];
		HashMap<Integer,Integer>map=new HashMap<>();
		
		for(int i=0;i<B.length;i++) {
			map.put(B[i], i);
		}
		for(int i=0;i<A.length;i++) {
			int b=map.get(A[i]);
			ans[i]=b;
			System.out.println(ans[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		System.out.println(anagramMappings(A,B)); //[1, 4, 3, 2, 0]

	}

}
