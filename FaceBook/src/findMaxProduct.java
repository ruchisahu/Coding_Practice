import java.util.ArrayList;
import java.util.List;

public class findMaxProduct {
	 static int[] findMaxProduct(int[] arr) {
	if (arr == null || arr.length == 0)
		return arr;
	List<Integer> listMaxThree = new ArrayList<Integer>();
	int[] retval = new int[arr.length];
	retval[0] = -1;
	retval[1] = -1;
	retval[2] = arr[0] * arr[1] * arr[2];
	listMaxThree.add(arr[0]);
	listMaxThree.add(arr[1]);
	listMaxThree.add(arr[2]);
	for (int i = 3; i < arr.length; i++)
	{
		int min = Min(listMaxThree);
		if (arr[i] > min)
		{ // replace the value of min 
			int idx = listMaxThree.indexOf(min);
			listMaxThree.remove(idx);
			
			listMaxThree.add(arr[i]);
		}

		retval[i] = listMaxThree.get(0) * listMaxThree.get(1) * listMaxThree.get(2);
	}

	return retval;
}

	private static int Min(List<Integer> list) {
		int min=list.get(0);
		for(int i=1;i<list.size();i++) {
			if(list.get(i)<min)min=list.get(i);
		}
		return min;
	}
	static int test_case_number = 1;
	 static void check(int[] expected, int[] output) {
		    int expected_size = expected.length; 
		    int output_size = output.length; 
		    boolean result = true; 
		    if (expected_size != output_size) {
		      result = false;
		    }
		    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
		      result &= (output[i] == expected[i]);
		    }
		    char rightTick = '\u2713';
		    char wrongTick = '\u2717';
		    if (result) {
		      System.out.println(rightTick + " Test #" + test_case_number);  
		    }
		    else {
		      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
		      printIntegerArray(expected); 
		      System.out.print(" Your output: ");
		      printIntegerArray(output);
		      System.out.println();
		    }
		    test_case_number++;
		  }
		  
		  static void printIntegerArray(int[] arr) {
		    int len = arr.length; 
		    System.out.print("[");
		    for(int i = 0; i < len; i++) {
		      if (i != 0) {
		        System.out.print(", ");
		      }
		      System.out.print(arr[i]);
		    }
		    System.out.print("]");
		  }

	public static void main(String[] args) {
		int[] arr_1 = {1, 2, 3, 4, 5};
	    int[] expected_1 = {-1, -1, 6, 24, 60};
	    int[] output_1 = findMaxProduct(arr_1);
	    check(expected_1, output_1);
	    
	    int[] arr_2 = {2, 4, 7, 1, 5, 3};
	    int[] expected_2 = {-1, -1, 56, 56, 140, 140};
	    int[] output_2 = findMaxProduct(arr_2);
	    check(expected_2, output_2);

	}

}
