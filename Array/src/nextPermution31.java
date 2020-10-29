
public class nextPermution31 {
	public static void nextPermutation(int[] nums)
    {
        int len=nums.length-2;
        while(len>=0 && nums[len+1]<=nums[len])
        {
            len--;
        }
        
        if(len>=0)
        {
           int j=nums.length-1;
           while(j>=0 && nums[j]<=nums[len])
           {
               j--;
           }
        
        swap(nums,len,j);
    }
    reverse(nums,len+1);
    for(int i=0;i<nums.length;i++)
    {
    System.out.println(nums[i]);
    
    }  
 }
    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

	public static void main(String[] args) {
		int[] nums= {1,5,8,4,7,6,5,4,3,1};
		nextPermutation(nums);

	}

}
