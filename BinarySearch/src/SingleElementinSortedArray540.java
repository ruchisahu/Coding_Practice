
public class SingleElementinSortedArray540 {
	public static int singleNonDuplicate(int[] nums) {
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int m=l+(r-l)/2;
            if(m%2==0){
                if(nums[m]!=nums[m+1])
                    r=m;
                else
                    l=m+1;
            }
            else
            {
                 if(nums[m]!=nums[m+1]){
                     l=m+1;
                 }
                     else{
                         r=m-1;
                 }
            }
        }
        return nums[l];
    }

	public static void main(String[] args) {
		int[] nums= {1,1,2,3,3,4,4,8,8};
		System.out.println(singleNonDuplicate(nums));

	}

}
