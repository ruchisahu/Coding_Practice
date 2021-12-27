import java.util.HashMap;

public class LargestNumberXOccursXTimes {
    public static int largestNumberX(int[] nums){
        if(nums == null || nums.length == 0) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int res = 0;

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        for(int num : nums){
            int value = map.get(num);
            if(value == num){
                res = Math.max(res,value);
            }
        }

        return res;

    }

    public static void main(String args[]) {
        //int[] arr = {3,8,2,3,3,2};
        int[] arr = {3,1,4,1,5};
        int x = largestNumberX(arr);
        System.out.println(x);

    }

}
