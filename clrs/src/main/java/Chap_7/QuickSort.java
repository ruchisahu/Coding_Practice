package Chap_7;

import java.util.Arrays;

import util.util;

public class QuickSort {
	
	private static void quicksort(int array[],int low,int high)
    {
        if(low < high)
        {
            int pivot = partition(array,low,high);
            quicksort(array,low,pivot-1);
            quicksort(array,pivot+1,high);
        }
    }
//
	private static int partition(int array[],int low,int high)
    {
     int pivot = array[high];
     int i = low-1;

        for(int j=low;j<=high-1;j++)
            if(array[j] <= pivot)
            util.swap(array,++i,j);
           
    util.swap(array,i+1,high);
    return i+1;
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
