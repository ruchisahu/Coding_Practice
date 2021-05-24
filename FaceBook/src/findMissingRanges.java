import java.util.ArrayList;
import java.util.List;
//163 missing range
public class findMissingRanges {
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            // 1. We don't need to add [Integer.MAX_VALUE, ...] to result
            if(lower == Integer.MAX_VALUE) return res;
            if (nums[i] < next) {
                continue;
            }
            if (nums[i] == next) {
                next++;
                continue;
            }
            res.add(getRange(next, nums[i] - 1));
            // 2. We don't need to proceed after we have process Integer.MAX_VALUE in array
            if(nums[i] == Integer.MAX_VALUE) return res;
            next = nums[i] + 1;
        }
        
        if (next <= upper) {
            res.add(getRange(next, upper));
        }
        return res;
    }
    
    public static String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d" , n1, n2);
    }

	public static void main(String[] args) {
		int[] nums = {0, 1, 3, 50, 75};
		int lower = 0;
		int upper = 99;
		System.out.println(findMissingRanges(nums,lower,upper));

	}

}
