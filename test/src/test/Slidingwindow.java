package test;

import java.util.Collections;
import java.util.PriorityQueue;

public class Slidingwindow {
   public static double[] medianSlidingWindow(int[] nums) {
	   PriorityQueue<Integer> minHeap = new PriorityQueue<>();
       // use Collections.reverseOrder() in order to prevent integer overflow
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       double[] result = new double[nums.length-1];
       int k=1;
       int start = 0;
       for (int end = 0; end < nums.length; end++) {
           maxHeap.add(nums[end]);
           
           if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
               minHeap.add(maxHeap.poll());
           }
           
           if (maxHeap.size() - minHeap.size() > 1) {
               minHeap.add(maxHeap.poll());
           }
           
           if (minHeap.size() - maxHeap.size() > 1) {
               maxHeap.add(minHeap.poll());
           }
           
           if (end - start + 1 >= k++) {
               if (k % 2 == 0) {
                   result[start] = ((long)maxHeap.peek() + (long)minHeap.peek()) / 2.0;
               }
                else if (maxHeap.size() > minHeap.size()) {
                   result[start] = maxHeap.peek() * 1.0;
               } else {
                   result[start] = minHeap.peek() * 1.0;
               }
               
               if (nums[start] > maxHeap.peek()) {
                   minHeap.remove(nums[start]);
               } else {
                   maxHeap.remove(nums[start]);
               }
               
               start++;
           } 
           
       }
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<result.length;i++) {
    	  sb.append(result[i]);
    	  sb.append(",");
       }
       System.out.println(sb);
       return result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5 2 4  6
		int[] arr= {5,2,4,6};
		medianSlidingWindow(arr);

	}

}
