
import java.util.Arrays;
import java.util.Random;


public class QuickSort {
	
	private static void quicksort(int array[],int low,int high)
    {
        if(low < high)
        {
            int pivot = partition(array,low,high);
            quicksort(array,low,pivot-1);
            quicksort(array,pivot+1,high);
        }
    }
//
	private static int partition(int array[],int low,int high)
    {
     int pivot = array[high];
     int i = low-1;

        for(int j=low;j<=high-1;j++)
            if(array[j] <= pivot)
            util.swap(array,++i,j);
           
    util.swap(array,i+1,high);
    return i+1;
    }
		
	//random pivot
	public static int partitionRan(int[] A, int p, int r) {
		// permute A[r] with a random element
		Random rand = null;
		int idx = rand.nextInt(r - p + 1) + p;
		util.swap(A,  idx, r);
		
		// choose a pivot
		int pivVal = A[r];
		
		// keep track of top idx of filtered vals
		int q = p;
		
		// do the filtering
		for (int i = p; i < r; i++) {
			if (A[i] <= pivVal) {
				util.swap(A, i, q);
				q++;
			}
		}
		util.swap(A, r, q);
		return q;
	}

	public static void main(String[] args) {
		int[] A = new int[10];
		util.fillWithRandomInts(A);
		//int[] A= {2,8,7,1,3,5,6,4};
		//int[] A= {4,3,2,1};
		System.out.println(Arrays.toString(A));
        int r=A.length-1;
        int p=0;
        quicksort(A,p,r);
		
		System.out.println(Arrays.toString(A));

	}

	

}
