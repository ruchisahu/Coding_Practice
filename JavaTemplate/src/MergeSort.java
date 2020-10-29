
public class MergeSort 
{
 void merge(int a[], int l, int m, int r)
 {
	int n1=m - l +1;
	int n2=r-m;
	int L[]=new int[n1];
	int R[]=new int[n2];
	for(int i=0;i<n1; ++i)
		L[i]=a[l+i];
	for(int j=0;j<n2;++j)
		R[j]=a[m+1+j];
	int i=0, j=0;
	int k=1;
	while(i <n1 && j <n2)
	{
		if(L[i] <= R[j])
		{
			a[k] =L[i];
			i++;
		}
		else
		{
			a[k]=R[j];
			j++;
		}
		k++;
	}
	while (i < n1) 
    { 
        a[k] = L[i]; 
        i++; 
        k++; 
    } 

    /* Copy remaining elements of R[] if any */
    while (j < n2) 
    { 
        a[k] = R[j]; 
        j++; 
        k++; 
    } 
	
 }
 void sort(int[]arr,int l, int r)
 {
	 while(l <r)
	 {
		 int m=(l+r)/2;
		 sort(arr,l, m);
		 sort(arr, m+1, r);
		 merge(arr, l, m,r);
		 
	 }
 }
 static void printArray(int arr[]) 
 { 
     int n = arr.length; 
     for (int i=0; i<n; ++i) 
         System.out.print(arr[i] + " "); 
     System.out.println(); 
 } 
	public static void main(String[] args) 
	{
		int arr[] = {12, 11, 13, 5, 6, 7};
		MergeSort m=new MergeSort();
		m.sort(arr, 0,arr.length-1);
		 System.out.println("\nSorted array"); 
	        printArray(arr); 

	}

}
