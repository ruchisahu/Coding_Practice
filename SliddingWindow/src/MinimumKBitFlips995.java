
public class MinimumKBitFlips995 {
	
	//different solution , not the same problem
	 public static int minKBitFlips(int[] A, int K) {
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
		int[] A= {0,0,0,1,0,1,1,0};
		int K=3;
		
		System.out.println(minKBitFlips(A, K)) ;
		
		
		int[] B= {0,1,0};
		int k1=	1;
		System.out.println(minKBitFlips(B, k1)) ;

	}

}
