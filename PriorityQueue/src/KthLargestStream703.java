import java.util.PriorityQueue;
//For add operation, both push and pop takes O(logn) time, so it’s time complexity is O(logn + 2logn) = O(logn).
public class KthLargestStream703 {
	PriorityQueue<Integer> pq;
	int k;
	 public KthLargestStream703(int k, int[] nums) {
		 this.k=k;
	        pq=new PriorityQueue<>(k);
	        for(int num:nums) {
	        	add(num);
	        }
	    }
	    
	    public int add(int val) {
	        if(pq.size()<k) {
	        	pq.offer(val);
	        }
	        else if(pq.peek()<val) {
	        	pq.poll();
	        	pq.offer(val);
	        }
	        return pq.peek();
	    }

	public static void main(String[] args) {
		int[] val= {4, 5, 8, 2};
		KthLargestStream703 kthLargest = new KthLargestStream703(3, val);
		System.out.println(kthLargest.add(3));   // return 4
		System.out.println(kthLargest.add(5));   // return 5
		System.out.println(kthLargest.add(10));  // return 5
		System.out.println(kthLargest.add(9));   // return 8
		System.out.println(kthLargest.add(4));   // return 8

	}

}
