package robertSedwick;

import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {
	
	    int[] a;
	    int index;
	    int length;
	    public BinarySearch(int N){
	        a = new int[N];
	        index = 0;
	        length = N;
	    }
	    public void add(int num){
	        a[index++] = num;
	    }
	    public int find(int num){
	        int low = 0,
	                high = length-1,
	                mid, midVal;
	        while(low <= high){
	            mid = low + (high-low)/2;
	            midVal = a[mid];
	            if(midVal > num)
	                high = mid - 1;
	            else if(midVal < num)
	                low = mid + 1;
	            else
	                return midVal;
	        }
	        return -1;
	    }
	    public static void main(String[] args){
	        Integer N = StdIn.readInt();
	        BinarySearch bs = new BinarySearch(N);
	        for(int i = 0; i < N;i++){
	            bs.add(StdIn.readInt());
	        }
	        while(!StdIn.isEmpty()){
	            int n ;
	            if(bs.find((n = StdIn.readInt()))==-1)
	                System.out.println(n);
	        }
	    }
	}

//O(logN)
//constant space O(1).