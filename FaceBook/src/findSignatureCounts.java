import java.io.IOException;
import java.util.Arrays;

public class findSignatureCounts {

	int[] findSignatureCounts(int[] arr) {
		if (arr != null && arr.length > 0)
		{
			//int[] curArr = new int[arr.length];
			int[] newArr = new int[arr.length];
			
			//arr.copyTo(curArr, 0);
			int[] curArr = Arrays.copyOf(arr, arr.length);
			boolean [] finishedArr = new boolean[arr.length];
			int[] signedCnt = new int[arr.length];
			int totalFinished = 0;
			while (totalFinished < arr.length)
			{
				for (int i = 0; i < arr.length; i++)
				{
					if (finishedArr[i] == false)
					{
						// sign the book
						signedCnt[i]++;
						int curNum = curArr[i];
						if (curNum - 1 == i) // passback to itself 
						{
							finishedArr[i] = true;
							totalFinished++;
						}
						else
						{
							newArr[curNum - 1] = curNum;
						}
					}
				}

			//	newArr.CopyTo(curArr, 0);
				curArr = Arrays.copyOf(newArr, arr.length);
				newArr = new int[arr.length];
			}

			return signedCnt;
		}

		return arr;
	    
	  }


	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom, but they are otherwise not editable!
	  int test_case_number = 1;
	  void check(int[] expected, int[] output) {
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
	  void printIntegerArray(int[] arr) {
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
	  
	  public void run() {
	    int[] arr_1 = {2, 1};
	    int[] expected_1 = {2, 2};
	    int[] output_1 = findSignatureCounts(arr_1);
	    check(expected_1, output_1);
	    
	    int[] arr_2 = {1, 2};
	    int[] expected_2 = {1, 1};
	    int[] output_2 = findSignatureCounts(arr_2);
	    check(expected_2, output_2);
	  
	    // Add your own test cases here
	    
	  }
	  
	  public static void main(String[] args) throws IOException {
	    new findSignatureCounts().run();
	  }
	}