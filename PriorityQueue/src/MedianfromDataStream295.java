import java.util.Collections;
import java.util.PriorityQueue;

public class MedianfromDataStream295 {
	 /** initialize your data structure here. */
   
   	static PriorityQueue<Integer> minpq = new PriorityQueue();
     static PriorityQueue<Integer> maxpq = new PriorityQueue(Collections.reverseOrder());
    
    
    public static void addNum(int num) {
        if(maxpq.isEmpty() || maxpq.peek()>num ) {
        	maxpq.add(num);
        }
        else
        	minpq.add(num);
        if(maxpq.size()>minpq.size()+1) {
        	minpq.add(maxpq.poll());
        }
        if(minpq.size()>maxpq.size()+1) {
        	maxpq.add(minpq.poll());
        }
    }
    
    public static double findMedian() {
    	if(maxpq.size()==minpq.size())
		return (maxpq.peek()+minpq.peek())/2.0;
    	else {
    		if(minpq.isEmpty())
    			return maxpq.peek();
    		else
    			return minpq.peek();
    	}
    		
    }

	public static void main(String[] args) {
		int[] num= {2,3,4};
		addNum(1);
		System.out.println(findMedian());
		addNum(2);
		System.out.println(findMedian());
		addNum(3);
		addNum(4);
		System.out.println(findMedian());

	}

}
