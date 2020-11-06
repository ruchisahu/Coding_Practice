package Chap_2;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.SortedMap;

import org.testng.annotations.Test;

public class InsertionSortTest {
	

  @Test
  public void test() {
	  InsertionSort in=new InsertionSort();
	  int[] A= {5,6,1,2};
	  int[] B= {5,6,1,2};
	  in.sort(A);
	  assertTrue(isEqual(A,sorted(B)));
  }
  
private boolean isEqual(int[] a, int[] b) {
	
	for (int i = 0; i < a.length; i++) {
		if(!(a[i]==b[i])) {
			return false;
		}
	}
	return true;
}
private int[] sorted(int[] a) {
      Arrays.sort(a);
      return a;
   }
}
