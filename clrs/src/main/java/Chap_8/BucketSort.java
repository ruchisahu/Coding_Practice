package Chap_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import util.util;

//need to  work on bucket size
public class BucketSort {

	public static void main(String[] args) {
		 float arr[] = { (float)0.897, (float)0.565, 
                 (float)0.656, (float)0.1234, 
                 (float)0.665, (float)0.3434 }; 

 int n = arr.length; 
 Sort(arr, n); 

 System.out.println("Sorted array is "); 
 for (float el : arr) { 
     System.out.print(el + " "); 
 } 

	}

	
	static void Sort(float arr[], int n) 
    { 
        if (n <= 0) 
            return; 
  
        // 1) Create n empty buckets 
        
        Vector<Float>[] buckets = new Vector[n]; 
  
        for (int i = 0; i < n; i++) { 
            buckets[i] = new Vector<Float>(); 
        } 
  
        // 2) Put array elements in different buckets 
        for (int i = 0; i < n; i++) { 
            float idx = arr[i] * n; 
            buckets[(int)idx].add(arr[i]); 
        } 
  
        // 3) Sort individual buckets 
        for (int i = 0; i < n; i++) { 
            Collections.sort(buckets[i]); 
        } 
  
        // 4) Concatenate all buckets into arr[] 
        int index = 0; 
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < buckets[i].size(); j++) { 
                arr[index++] = buckets[i].get(j); 
            } 
        } 
    } 
}
  
