import java.util.*;

public class minBitFlips995 {
/*	Algorithm:
		We declare a queue which is the flip queue
		The res variable will hold the number of total flips done at any point
		We iterate from 0 till the length of the Array, and do the following
		3.1 If we encounter a 0 and the no. of flips is even OR we encounter a 1 and the no. of flips is odd we
		increment the result and mark the end i+k-1 in the queue
		3.2 If the last index of the flip > n we return -1 because then its not possible to achieve the final result
		as dont have enough values to flip
		3.3 We remove the head of the queue as we reach the last index of the flip
		Code:
		*/
		    public static int minKBitFlips(int[] A, int K) {
		        int n = A.length;
		        Queue<Integer> fq = new LinkedList<>();
		        int res = 0;
		        
		        for(int i=0; i<n; i++) {
		            if ((A[i] == 0 && fq.size()%2 == 0) || (A[i]==1 && fq.size()%2 == 1)) {
		                res++;
		                if (i+K > n) return -1;
		                fq.add(i+K-1);
		            } //fi
		            if (fq.size() > 0 && fq.peek() == i) {
		                fq.remove();
		            }
		        }//for
		        return res;
		    }
		 //   sol2
		    public static int minKBitFlips1(int[] A, int K) {
		        int max=0;
		  		 for(int i=0;i<A.length-K;i++) {
		  			 int[] B=getSliceOfArray(A,i,i+K);
		  			 int slice=maxSlice(B);
		  			 max=Math.max(max, slice);
		  		 }
		  		return max;
		  	        
		  	    }
		  	 private static int maxSlice(int[] b) {
		  		 int count=0;
		  		 for(int i=0;i<b.length;i++) {
		  			 if(b[i]!=1)count++;
		  		 }
		  		
		  		return count;
		  	}
		  public static int[] getSliceOfArray(int[] arr, int start, int end) 
		  { 
		  	int[] slice = new int[end - start]; 
		  	for (int i = 0; i < slice.length; i++) { 
		  	     slice[i] = arr[start + i]; 
		  	} 
		  	return slice; 
		     
		      }
		  

	public static void main(String[] args) {
		int[] A = {0,0,0,1,0,1,1,0};
				int K = 3;
				System.out.println(minKBitFlips(A,K));
				System.out.println(minKBitFlips1(A,K));

	}

}
