package Chap_2;

import java.util.Arrays;

public class MergeSort_withoutSentinel {

	
		public static void Merge_Sort(int[] A, int p, int r){
			if(p<r) {
				int q = (int) Math.floor((p + r) / 2);
			
			Merge_Sort(A,p,q);
			Merge_Sort(A,q+1,r);
			Merge(A,p,q,r);
			}
		}

		private static void Merge(int[] arr,int p, int q, int r) {
			
			int n1 = q - p + 1;
		    int n2 = r - q;
		    int L[] = new int[n1+1];
	        int M[] = new int[n2+1];

		  //  int L[n1], M[n2];

		    for (int i = 0; i < n1; i++)
		        L[i] = arr[p + i];
		    for (int j = 0; j < n2; j++)
		        M[j] = arr[q + 1 + j];

		    // Maintain current index of sub-arrays and main array
		    int i, j, k;
		    i = 0;
		    j = 0;
		    k = p;

		    // Until we reach either end of either L or M, pick larger among
		    // elements L and M and place them in the correct position at A[p..r]
		    while (i < n1 && j < n2) {
		        if (L[i] <= M[j]) {
		            arr[k] = L[i];
		            i++;
		        } else {
		            arr[k] = M[j];
		            j++;
		        }
		        k++;
		    }

		    // When we run out of elements in either L or M,
		    // pick up the remaining elements and put in A[p..r]
		    while (i < n1) {
		        arr[k] = L[i];
		        i++;
		        k++;
		    }

		    while (j < n2) {
		        arr[k] = M[j];
		        j++;
		        k++;
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
