import java.util.Stack;

//https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
public class nearestLeftSmaller {

	static void printPrevSmaller(int []arr, int n)
	{
	// Start from second element
		for (int i = 1; i < n; i++)
		{
			int j;
			for(j = i - 1; j >= 0; j--)
			{
				if (arr[j] < arr[i])
				{
					System.out.print(arr[j] + ", ");
					break;
				}
			}
			if (j == -1)
			System.out.print( "_, ") ;
		}
	}
	static void printPrevSmaller1(int arr[], int n) {
        // Create an empty stack
        Stack<Integer> S = new Stack<>();
 
        // Traverse all array elements
        for (int i = 0; i < n; i++) {
            // Keep removing top element from S while the top
            // element is greater than or equal to arr[i]
            while (!S.empty() && S.peek() >= arr[i]) {
                S.pop();
            }
 
            // If all elements in S were greater than arr[i]
            if (S.empty()) {
                System.out.print("_, ");
            } else //Else print the nearest smaller element
            {
                System.out.print(S.peek() + ", ");
            }
 
            // Push this element
            S.push(arr[i]);
        }
	}

		// Driver Code
		public static void main (String[] args)
		{
			int []arr = {2,1,3,2,1,3};
			int n = arr.length;
			printPrevSmaller(arr, n);
		}
	

}
