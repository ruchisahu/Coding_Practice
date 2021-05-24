
//https://leetcode.com/problems/split-array-largest-sum/discuss/819170/6-questions-in-one-template-of-binary-search-for-beginners!-python
public class shipWithdays {
	public static int shipWithinDays(int[] weights, int D) {
	      int left = 0;
	        int sum = 0;
	        for (int w : weights) {
	            sum += w;
	        }
	        int right = sum;
	        int result = Integer.MAX_VALUE;
	        while (left <= right) {
	            int mid = (left + right) / 2;
	            if (isPossible(weights, mid, D)) {
	                result = Math.min(result, mid);
	                right = mid - 1;
	            } else {
	                left = mid + 1;
	            }
	        }
	        return result;
	    }
	    public static boolean isPossible(int[] weights, int mid, int D) {
	        int limit = 1;
	        int curr = 0;
	        for (int i = 0; i < weights.length; i++) {
	            if (weights[i] > mid) {
	                return false;
	            }
	            if (weights[i] + curr > mid) {
	                curr = weights[i];
	                limit++;
	                if (limit > D) {
	                    return false;
	                }
	            } else {
	                curr += weights[i]; 
	            }
	            
	        }
	        return true;
	    }

	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		int D = 5;
		System.out.println(shipWithinDays(weights,D));

	}

}
