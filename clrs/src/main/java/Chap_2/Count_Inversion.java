package Chap_2;
//need to check this
import java.util.Arrays;
//O(nlogn)
public class Count_Inversion {

	public static int Inversion(int[] A, int p, int r){
		int inversions=0;
		if(p<r) {
			int q = (int) Math.floor((p + r) / 2);
		
		int left=Inversion(A,p,q);
		int right=Inversion(A,q+1,r);
		 inversions = MERGE_INVERSIONS(A, p, q, r) + left + right;
		        return inversions;
		}
		return 0;
	}

	

	private static int MERGE_INVERSIONS(int[] arr,int p, int q, int r) {
		
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
	        int inversions=0;

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
	            	inversions = inversions + n - i + 1;
	                arr[k] = R[j];
	                j = j+1;

	            }           
	        }
			return inversions;
	    
	    
		
	}


	public static void main(String[] args) {
		int[] A= {9,6,8,4};
		int p=0;
		int r=A.length-1;
		
		System.out.println(Inversion(A,p,r));
		

	}

}
