
public class CombinationSum377 {
	// is used to calculate the number of combinations NOT considering different sequences
	public static int combinationSum4(int[] nums, int target) {
	int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}
	//can not repeat same no
	//is used to calculate the number of combinations considering different sequences
	public static int combinationSum(int[] nums, int target) {
		int[] comb = new int[target + 1];
	    comb[0] = 1;
	    for (int j = 0; j < nums.length; j++) {
	    for (int i = 1; i < comb.length; i++) {
	        if (i - nums[j] >= 0) {
	                comb[i] += comb[i - nums[j]];
	            }
	        }
	    }
	    return comb[target];
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		int target = 4;
		System.out.println("sum:"+combinationSum4(nums, target));
		System.out.println("sum:"+combinationSum(nums, target));
	}

}
