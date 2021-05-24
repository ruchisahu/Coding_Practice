import java.util.ArrayList;
import java.util.List;

public class arraysIntersection {
	class Solution {
	    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
	        List<Integer> res = new ArrayList<>();
	        if(arr1 == null || arr2 == null || arr3 == null){
	            return res;
	        }

	        int i = 0;
	        int j = 0;
	        int k = 0;
	        while(i < arr1.length && j < arr2.length && k < arr3.length){
	            if(arr1[i] == arr2[j] && arr1[i] == arr3[k]){
	                res.add(arr1[i]);
	                i++;
	                j++;
	                k++;
	            }else if(arr1[i] < arr2[j]){
	                i++;
	            }else if(arr2[j] < arr3[k]){
	                j++;
	            }else{
	                k++;
	            }
	        }

	        return res;
	    }
	}

}
