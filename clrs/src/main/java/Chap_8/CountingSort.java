package Chap_8;

import java.util.Arrays;

import util.util;

public class CountingSort {
	public static int[] countingSort(int[] A, int k) {
		int[] C=new int[k+1];
		int[] B=new int[A.length];
		
		for(int i=0;i<C.length;i++)
			C[i]=0;
		
		for(int i=0;i<A.length;i++) {
			C[A[i]]=C[A[i]]+1;
		}
		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}
		
		for(int j=A.length-1;j>=0;j--) {
			B[C[A[j]]-1]=A[j];
			C[A[j]]--;
		}
		return B;
		
	}

	public static void main(String[] args) {
		int arrayLen = 20;
		System.out.println("\nCounting Sort test");
		//int[] array = new int[arrayLen];
	//	util.fillWithRandomInts(array);
		int[] array= {2,5,3,0,2,3,0,3};
		
		System.out.println(Arrays.toString(array));
		array = countingSort(array, arrayLen * 4);
		System.out.println(Arrays.toString(array));

	}

}
