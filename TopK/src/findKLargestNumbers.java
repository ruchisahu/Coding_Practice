import java.util.*;
import java.util.stream.Collectors;

public class findKLargestNumbers {
	public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        // TODO: Write your code here
        if (nums.length <= k) return Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) queue.add(nums[i]);
        while (k-- > 0) result.add(queue.poll());
        return result;
    }
	
	//sol2:
	public static List<Integer> findKLargestNumbers1(int[] nums, int k) {
		List<Integer>result=new ArrayList<>();
		Queue<Integer>pq=new PriorityQueue<>();
		for(int i=0;i<nums.length;i++) {
			pq.add(nums[i]);
			if(pq.size()>k) {
				pq.poll();
			}
		}
			while(k-->0) {
				System.out.println(pq.peek());
				result.add(pq.poll());
			}
		
		return result;
	}
	

    public static void main(String[] args) {
        List<Integer> result = findKLargestNumbers.findKLargestNumbers1(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = findKLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }


}
