//Given two arrays(of different lengths),int lower,int upper, count how many pairs have the following property
//lower <= a[i]*a[i] +b[j]*b[j] <= higher
public class FindPairs {
	public static int findPair(int[] a,int[]b,int low,int high) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				int sum=a[i]*a[i] +b[j]*b[j];
				if(low <=sum && sum<=high) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] a= {1, 2, 3, 4, 5};
		int[]b= {6, 7, 8, 9, 10};
		int low=25;
		int high=80;
		System.out.println(findPair(a,b,low,high));

	}

}
