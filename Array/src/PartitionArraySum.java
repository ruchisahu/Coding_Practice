
public class PartitionArraySum 
{
	

	public static void main(String[] args) {
		int[] nums= {1,1,1};
		System.out.println(getSubsetnums(nums));

	}

	private static int getSubsetnums(int[] nums) {
		int n = nums.length;
		if(n<3) return 0;
		int[] prefix = new int[n];
		prefix[0] = nums[0];
		
		for(int i=1; i<n; i++) {
			prefix[i] = prefix[i-1] + nums[i];
		}
		int answer = 0;
		
		for(int i=0; i<=n-3; i++) {
			for(int j=i+1; j<=n-2; j++) {
				if((prefix[i] <= prefix[j]-prefix[i]) && (prefix[j]-prefix[i] <= prefix[n-1]-prefix[j])) {
					answer++;
				}
			}
		}
		
		return answer;
	}

}
