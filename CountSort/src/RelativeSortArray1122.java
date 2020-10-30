//https://leetcode.com/problems/relative-sort-array/
public class RelativeSortArray1122 {
	 public static int[] relativeSortArray(int[] arr1, int[] arr2) {
		 int[] count=new int[1001];
		 for(int i=0;i<arr1.length;i++) {
			 count[arr1[i]]++;
		 }
		 int k=0;
		 for(int j=0;j<arr2.length;j++) {
			 while(count[arr2[j]]!=0) {
				 arr1[k++]=arr2[j];
                 count[arr2[j]]--;
			 }
		 }
		 for(int m=0;m<count.length;m++) {
			 while(count[m]!=0) {
				 arr1[k++]=m;
                 count[m]--;
			 }
		 }
		 for(int i=0;i<arr1.length;i++) {
			 System.out.println(arr1[i]);
		 }
		return arr1;
	        
	    }

	public static void main(String[] args) {
		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
		int[] arr2 = {2,1,4,3,9,6};
		relativeSortArray(arr1, arr2);

	}

}
