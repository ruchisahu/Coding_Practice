package Chap_9;

import java.util.Arrays;

import util.util;

public class Randomized_Select {

	private static int quicksort_select(int array[],int low,int high,int i)
    {
        if(low== high)
        	return array[low];
        
        
            int pivot = partition(array,low,high);
           
            if(i==pivot)
            	return array[pivot];
            else if(i <pivot) {
           return quicksort_select(array,low,pivot-1,i);
            }
            else {
            	return quicksort_select(array,pivot+1,high,i);
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
        int small=0;
        System.out.println(quicksort_select(A,p,r,small));
		
		System.out.println(Arrays.toString(A));

	}

	

}
