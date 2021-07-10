package test;

import java.util.Arrays;

public class AwesomeSort {
	   
	    static void EvenAndOdd(int arr[]) {
	    	int n=arr.length;
	    	 int[] output = new int[n];
	    	    int count = 0;

	    	    for (int i=0; i < n; ++i) {
	    	        if (arr[i] % 2 == 0) output[count++] = arr[i];
	    	    }

	    	    for (int i=0; i < n; ++i) {
	    	        if (arr[i] % 2 == 1) output[count++] = arr[i];
	    	    }

	    	    for (int i = 0; i < arr.length; i++)
	                arr[i] = output[i];
	    	
	    }
	    
	    static void EvenDivideBy5(int arr[]) {
	        int j = 0, temp;
	        int left=-1;
	        int right=-1;
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] % 2 ==0 && arr[i]%5 == 0) {
	            	//left=Math.min(left, i);
	            	//right=Math.max(right, i);
	                temp = arr[j];
	                arr[j] = arr[i];
	                arr[i] = temp;
	                j++;
	            }
	        }
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] % 2 ==0 && arr[i]%5 != 0) {
	                left=i;
	                break;
	            }
	         }
	        for (int i = arr.length-1; i>=0; i--) {
	            if (arr[i] % 2 ==0 && arr[i]%5 != 0) {
	                right=i;
	                break;
	            }
	            }
	        reverse(arr, left, right);
	        
	        for (int i = arr.length-1; i>=0; i--) {
	            if (arr[i] % 2 ==0 && arr[i]%5 == 0) {
	                right=i;
	                break;
	            }
	            } 
	        for (int i = 0; i < arr.length; i++) {
	            if (arr[i] % 2 ==0 && arr[i]%5 == 0) {
	                left=i;
	                break;
	            }
	         }
	        printArray(arr);
	        Arrays.sort(arr, left, right + 1);
	        printArray(arr);
	       
	    }
	    public static void reverse(int[] arr, int l, int r)
	    {
	        int d = (r-l+1)/2;
	        for(int i=0;i<d;i++)
	        {
	           int t = arr[l+i];
	           arr[l+i] = arr[r-i];
	           arr[r-i] = t;
	        }
	       
	    }
	    static void printArray(int arr[]) {
	        for(int i=0;i<arr.length;i++)
	            System.out.print(arr[i]+"\t");
	        System.out.println();
	    }
	    public static void main(String args[]) {
	        int arr[] = {1,5,2,10,4,7,3,20};
	        System.out.println("Before:");
	        printArray(arr);
	        EvenAndOdd(arr);
	        System.out.println("After:");
	        printArray(arr);
	        EvenDivideBy5(arr);
	        System.out.println("After:");
	        printArray(arr);
	    }
	}