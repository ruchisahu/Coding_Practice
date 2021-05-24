import java.util.*;

public class SortaNearlySorted {
	/* Function to sort an array using insertion sort*/
	static void insertionSort(int arr[], int k)
	{
		 // min heap
		int n=arr.length;
        PriorityQueue<Integer> priorityQueue
            = new PriorityQueue<>();
 
        // add first k + 1 items to the min heap
        for (int i = 0; i < k + 1; i++) {
            priorityQueue.add(arr[i]);
        }
 
        int index = 0;
        for (int i = k + 1; i < n; i++) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
            priorityQueue.add(arr[i]);
        }
 
        Iterator<Integer> itr = priorityQueue.iterator();
 
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
    
	}

	// A utility function to print the array
    private static void printArray(int[] arr, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
 
    // Driver Code
    public static void main(String[] args)
    {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        int n = arr.length;
        insertionSort(arr,k);
        System.out.println("Following is sorted array");
        printArray(arr, n);
    }
}
