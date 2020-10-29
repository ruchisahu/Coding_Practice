import java.util.Arrays;

// "static void main" must be defined in a public class.
//https://leetcode.com/discuss/interview-question/355698/amazon-oa-2019-find-pair-with-max-appeal-sum/323219
/*
 * Find pair with maximum Appeal value.

Input: Array
Output: index {i, j} ( i = j allowed) with maximum Appeal
Appeal = A[i] +A[j] + abs(i-j)

Example 1:

Input: [1, 3, -1]
Output: [1, 1]
Explanation: Appeal = A[1] + A[1] + abs(0) = 3 + 3 + 0 = 6
Example 2:

Input: [1, 6, 1, 1, 1, 1, 7]
Output: [1, 6]
Explanation 6 + 7 + abs(1 - 6) = 18
 */
public class MaxAppealSum {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //int[] a = new int[]{1, 3, -1};
        //int[] a = new int[]{1, 2, 6, 7, 4, 1, 5};
        int[] a = new int[]{3, 5, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] pair = maxAppealVal(a);
        System.out.println(pair[0]+ " "+pair[1]);
    }
    
    public static int[] maxAppealSum(int[] nums) {
        int max = 0;
        int[] result= new int[2];
        
        int left = 0;
        int right = nums.length-1;
        System.out.println(Arrays.toString(nums));
        while(left <= right ){
            System.out.println(left +" "+right);
            int sum = nums[left] + nums[right] + Math.abs(right- left);
            if(sum > max){
                max = sum;
                result[0] = left;
                result[1] = right;
            }
            
            else if(nums[left] < nums[right]){
                left++;
            }
            else{
                right --;
            }
        }
        return result;
    
    }
    
    //O(n) time complexity
    //O(1) space
    private static int[] maxAppealVal(int[] arr) {
        int left=0;
        int right=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int val = arr[i]-i;
            if(val>max) {
                max = val;
                left =i;
            }
        }
        max=Integer.MIN_VALUE;
        for(int i=arr.length-1;i>-1;i--){
            int val = arr[i]-(arr.length-1-i);
            if(val>max) {
                max = val;
                right =i;
            }
        }
        return new int[]{left,right};
    }
    
    public int maxScoreSightseeingPair(int[] a) {
        int max_so_far = a[0];
        
        int result = 0;
        for(int i=1;i<a.length;i++)
        {
            result = Math.max(result, max_so_far + a[i] - i);
            max_so_far = Math.max(max_so_far, a[i] + i);
        }   
        return result;
    }
}