package Chap_6;

import java.util.Arrays;

import util.util;

public class HeapSort {
	private static void heapSort(int[] A) {
		int heapMaxSize = A.length - 1;
		buildMaxHeap(A);
		for (int i = A.length - 1; i > 0; i--) {
			swap(A, 0, i);  // since A[0] is max element
			heapMaxSize--;
			maxHeapify(A, 0, heapMaxSize);
		}
		
	}
	
	private static int parentIdx(int i) {
		return (i-1)/2;
	}
	
	private static int leftIdx(int i) {
		return 2* i +1;
	}
	
	private static int rightIdx(int i) {
		return 2* i +2;
	}
	
	public static void maxHeapify(int[] A, int i, int heapMaxSize) {
		int largest=i;
		int L=leftIdx(i);
		int R=rightIdx(i);
		if(L <=heapMaxSize && A[L] > A[largest] ) {
			largest=L;
		}
		if(R <=heapMaxSize && A[R] > A[largest] ) {
			largest=R;
		}
		if(largest!=i) {
			swap(A,i,largest);
			maxHeapify(A,largest,heapMaxSize);
		}
		
	}
	
	//this code is for Min-heapify same as maxheapify
	public static void minHeapify(int[] A, int i, int heapMaxSize) {
	int smallest=i;
	int L=leftIdx(i);
	int R=rightIdx(i);
	if(L <=heapMaxSize && A[L] < A[smallest] ) {
		smallest=L;
	}
	if(R <=heapMaxSize && A[R] < A[smallest] ) {
		smallest=R;
	}
	if(smallest!=i) {
		swap(A,i,smallest);
		minHeapify(A,smallest,heapMaxSize);
	}
	
}
	
	public static void buildMaxHeap(int[] A) {
		int heapMaxSize=A.length-1;
		for(int i=heapMaxSize/2;i>=0;i--) {
			maxHeapify(A, i, heapMaxSize);
		}
	}

	private static void swap(int[] A, int i, int l) {
		int t=A[i];
		A[i]=A[l];
		A[l]=t;
		
		
	}
	
	private static int heapMaximum(int[] A) {
		return A[0];
	}
	
	private static int heapExtractMax(int[] A,int size) {
		if(size<=0) {
			return -1;
		}
		
		int max=A[0];
		A[0]=A[size];
		size=size-1;
		maxHeapify(A, 0, size);
		
		return A[0];
	}

	public static void main(String[] args) {
		int[] array = new int[20];
		util.fillWithRandomInts(array);
		System.out.println(Arrays.toString(array));
		heapSort(array);
		System.out.println(Arrays.toString(array));

	}

	
}
