import java.util.PriorityQueue;

public class SumOfElements {
	public static int findSumOfElements(int[] nums, int k1, int k2) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num: nums) queue.add(num);
        int sum = 0;
        for (int i = 0; i < k1; i++) queue.poll();
        for (int i = 0; i < k2-k1-1; i++) {
        	System.out.println(queue.peek());
        	sum += queue.poll();}
        return sum;
    }

    public static void main(String[] args) {
        int result = SumOfElements.findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);  //23
     //   System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = SumOfElements.findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);    //12
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}


