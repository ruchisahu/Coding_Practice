import java.util.Collections;
import java.util.PriorityQueue;
//https://interviewdaemon.com/courses/two-heaps/lessons/find-median-from-continuous-data-stream/
public class FindMedianFromDataStream {
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
		FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
		medianFinder.addNum(1);    // arr = [1]
		medianFinder.addNum(2);    // arr = [1, 2]
		medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3);    // arr[1, 2, 3]
		medianFinder.findMedian(); // return 2.0

	}

}
