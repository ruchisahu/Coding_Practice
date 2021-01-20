package test;

import java.util.Arrays;
import java.util.Random;

	public class QuickSort {
		
		private static void quicksort(int array[],int low,int high)
	    {
	      if(low<high) {
	    	  int q=partition(array,low,high);
	    	  quicksort(array,low,q-1);
	    	  quicksort(array, q+1,high);
	    	  
	      }
	        
	    }
	//
		private static int partition(int a[],int low,int high)
	    {
			int pivot=a[high];
			int i=low-1;
			for(int j=low;j<=high-1;j++) {
				if(a[j]<pivot) {
					swap(a,++i,j);
				}
			}
			swap(a,++i,high);
			return i+1;
			
	    }
			
		

		private static void swap(int[] a, int i, int j) {
			int t=a[i];
			a[j]=a[i];
			a[i]=t;
		
		
	}



		public static void main(String[] args) {
			//int[] A = new int[10];
			//util.fillWithRandomInts(A);
			int[] A= {2,8,7,1,3,5,6,4};
			//int[] A= {4,3,2,1};
			System.out.println(Arrays.toString(A));
	        int r=A.length-1;
	        int p=0;
	        quicksort(A,p,r);
			
			System.out.println(Arrays.toString(A));

		}

		

	}
