package Chap_2;

import java.util.Arrays;

public class MergeSort {
	public static void Merge_Sort(int[] A, int p, int r){
		if(p<r) {
			int q = (int) Math.floor((p + r) / 2);
		
		Merge_Sort(A,p,q);
		Merge_Sort(A,q+1,r);
		Merge(A,p,q,r);
		}
	}

	private static void Merge(int[] arr,int p, int q, int r) {
		
		 int n = q-p+1;
	        int m = r-q;

	        int L[] = new int[n+1];
	        int R[] = new int[m+1];
	        int i,j,k;

	        for(i=0; i< n; i++)
	        {
	            L[i] = arr[p+i];    
	        }
	        for(j=0; j< m; j++)
	        {
	            R[j] = arr[q+j+1];    
	        }

	        L[n] = Integer.MAX_VALUE;  ////INT_MAX is our sentinel, which will be used in the merge step. No possible int will be greater than INT_MAX, so during the merge,
	        R[m] = Integer.MAX_VALUE;

	        i = 0;
	        j = 0;
	        for(k = p; k<= r; k++)
	        {

	            if( L[i]<=R[j])
	            {
	                arr[k] = L[i];
	                i = i+1;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j = j+1;

	            }           
	        }
	    
	    
		
	}
	//sol2
	public static int[] merge(int[] array, int p, int q, int r) {
		int[] list1 = Arrays.copyOfRange(array, p, q + 1);
		int[] list2 = Arrays.copyOfRange(array, q + 1, r + 1);
		int j = 0, k = 0, i = p;
		while ((j < list1.length) || (k < list2.length)) {
			if ((k < list2.length && j < list1.length && list1[j] >= list2[k]) || j >= list1.length) {
				array[i] = list2[k];
				k++;
			} else if (j < list1.length) {
				array[i] = list1[j];
				j++;
			}
			i++;
		}
		return array;
	}

	public static void main(String[] args) {
		int[] A= {4,2,5,1,7,9,1};
		int p=0;
		int r=A.length-1;
		
		Merge_Sort(A,p,r);
		for(int i=0;i<=r;i++) {
			System.out.println(A[i]);
		}

	}

}
