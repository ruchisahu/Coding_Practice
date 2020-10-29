package Chap_2;

public class InsertionSort {
	 public static void sort(int[] A) {
		 int key;
		 int j;
		 for(int i=1;i<A.length;i++) {
			 key=A[i];
			 j=i-1;
			 while(j>=0 && A[j]>key) {
				 A[j+1]=A[j--];
			 }
			 A[j+1]=key;
		 }
		 
		 for(int k=0;k<A.length;k++) {
			 System.out.println(A[k]);
		 }
	 }
	    

	public static void main(String[] args) {
		int[] array= {4,6,1,2,9,0};
		sort(array);

	}

}
