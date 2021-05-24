
public class areTheyEqual {
	static void reverse(int arr[], int l, int r)
    {
        int d = (r-l+1)/2;
      for(int i=0;i<d;i++)
      {
         int t = arr[l+i];
         arr[l+i] = arr[r-i];
         arr[r-i] = t;
      }
        
     System.out.println("Reversed array is: \n");
        for (int k = 0; k < arr.length; k++) {
            System.out.println(arr[k]);
        }
   }
  

  static boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here
    int l=0;
    int r=array_b.length-1;
    
      while(array_a[l]==array_b[l] && l<=r){
        l++;
      }
    while(array_a[r]==array_b[r] && l<r){
        r--;
      }
    if(l==r)return true;
    
    reverse(array_b, l,r);
    
    for(int i=0;i<=r;i++){
      if(array_a[i]!=array_b[i])return false;
    }
    return true;
  }
  
  static int test_case_number = 1;
  static void check(boolean expected, boolean output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    }
    else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      System.out.print(expected); 
      System.out.print(" Your output: ");
      System.out.print(output);
      System.out.println();
    }
    test_case_number++;
  }



	public static void main(String[] args) {
		int[] array_a_1 = {1, 2, 3, 4};
	    int[] array_b_1 = {1, 4, 3, 2};
	    boolean expected_1 = true;
	    boolean output_1 = areTheyEqual(array_a_1, array_b_1); 
	    check(expected_1, output_1); 

	    int[] array_a_2 = {1, 2, 3, 4};
	    int[] array_b_2 = {1, 4, 3, 3};
	    boolean expected_2 = false;
	    boolean output_2 = areTheyEqual(array_a_2, array_b_2); 
	    check(expected_2, output_2); 
		// TODO Auto-generated method stub

	}

}
