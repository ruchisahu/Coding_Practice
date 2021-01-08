import java.util.HashSet;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums){
		int missingNo = -1;
		HashSet<Integer>set=new HashSet<>();
		int min=Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++ ) {
			if(nums[i]>0) {
				set.add(nums[i]);
				min=Math.min(min, nums[i]);
			}
			
		}
		for(int i=1;i<=set.size();i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		
		return missingNo;
	}

	public static void main(String[] args) {
		int[] nums = {7,8,9,11,12};
		System.out.println(firstMissingPositive(nums));  //1
		
		int[] nums1 = {3,4,-1,1};
		System.out.println(firstMissingPositive(nums1));

	}

}
