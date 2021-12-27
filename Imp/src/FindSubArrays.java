public class FindSubArrays {
    public static int findArrays(int k, int[] nums){
        if(nums == null|| nums.length < 2 * k) return -1;

        for(int i = 0; i < nums.length - 2 * k - 1; i++){
            int diff = nums[i + 1] - nums[i];
            for(int j = i + (k - 1); j < k; j++){
                if(nums[j] - nums[j - 1]!= diff){
                    break;
                }
            }
            return i;
        }
        return -1;
    }

    public static void main(String args[]){
        int k = 3;
        int[] arr = new int[]{1, 2, 3, 5, 6, 7, 8};
        System.out.println(findArrays(k,arr));
    }
}
