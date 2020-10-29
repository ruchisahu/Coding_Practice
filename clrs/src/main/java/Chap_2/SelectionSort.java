package Chap_2;

public class SelectionSort {
	public static void Sort(int[] A, int p, int r){
		for(int i=0;i<r;i++) {
			int smallest=A[i];
			for(int j=i+1;j<=r;j++) {
				if(smallest>A[j]) {
					smallest=A[j];
					swap(A,i,j);
				}
			}
		}
		
	}

	private static void swap(int[] A,int i, int j) {
		int temp=A[i];
		A[i]=A[j];
		A[j]=temp;
		
		
		
	}

	public static void main(String[] args) {
		int[] A= {4,2,5,1,7,9,1,10,3};
		int p=0;
		int r=A.length-1;
		
		Sort(A,p,r);
		for(int i=0;i<=r;i++) {
			System.out.println(A[i]);
		}

	}

}
