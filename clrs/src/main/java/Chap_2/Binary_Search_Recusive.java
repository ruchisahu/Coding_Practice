package Chap_2;
//Complexity(value = "O(ln(n))", explanation = "since we halve the search target until the width of
public class Binary_Search_Recusive {
	public static int Binay_Search(int[] A, int target,int low, int high){
		while(low <=high) {
			int mid=(int )Math.floor((low+high)/2);
			if(A[mid]==target)
				return mid;
			else if(target>A[mid]) {
				Binay_Search(A,target,mid+1,high);
				
			}
			else
				Binay_Search(A,target,low,mid-1);
				
		}
		return 0;
		
	}

	public static void main(String[] args) {
		int[] A= {4,2,5,1,7,9,1,10,3};
		int p=0;
		int r=A.length-1;
		int target=7;
		System.out.println(Binay_Search(A,target,p,r));


	}

}
