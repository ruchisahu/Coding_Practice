package Chap_7;

import java.util.Arrays;

import util.util;

public class HoarePartition {
	
	private static void quicksort(int array[],int low,int high)
    {
        if(low < high)
        {
            int pivot = partition1(array,low,high);
            quicksort(array,low,pivot);
            quicksort(array,pivot+1,high);
        }
    }
//
	private static int partition(int array[],int low,int high)
    {
     int pivot = array[high];
     int left = low+1;
     int right=high-1;
     while(left<right)
     {
    	 while(right>left && array[right]>=pivot) {
    		 right--;
    	 }
    	 while(right>left && array[left]<pivot) {
    		 left++;
    	 }
    	 if(left <right) 
    	 {
    		 util.swap(array,left, right);
    	 }
     }
    	 if(pivot> array[left])
    	 {
    		 util.swap(array, left, low);
    		 return left;
    	 }
    	 else {
    		 return low;
    		 
    	 }
    		
    	 
    	 
     }
     
	static int partition1(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;
 
        while (true) {
            // Find leftmost element greater
            // than or equal to pivot
            do {
                i++;
            } while (arr[i] < pivot);
 
            // Find rightmost element smaller
            // than or equal to pivot
            do {
                j--;
            } while (arr[j] > pivot);
 
            // If two pointers met.
            if (i >= j)
                return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            // swap(arr[i], arr[j]);
        }
    }

      
    
		
	

	public static void main(String[] args) {
		//int[] A = new int[10];
	//	util.fillWithRandomInts(A);
		int[] A= {2,8,7,1,3,5,6,4};
		System.out.println(Arrays.toString(A));
        int r=A.length-1;
        int p=0;
        quicksort(A,p,r);
		
		System.out.println(Arrays.toString(A));

	}

	

}