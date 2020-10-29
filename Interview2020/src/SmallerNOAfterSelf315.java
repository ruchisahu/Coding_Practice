//https://kennyzhuang.gitbooks.io/algorithms-collection/content/count_of_smaller_numbers_after_self.html
import java.util.*;

public class SmallerNOAfterSelf315 {
public static List<Integer> countSmaller(int[] a) {
	 int len=a.length;
     List<Integer> result=new ArrayList<Integer>();
    
     for(int i=0;i<len;i++){
          int count=0;
         for(int j=i+1;j<len;j++){
             if(a[i]>a[j]){
                 count++;
             }
            
             
         }
          result.add(count);
     }
     return result;
    }

//sol2
private void add(int[] bit, int i, int val) {
    for (; i < bit.length; i += i & -i) bit[i] += val;
}

private int query(int[] bit, int i) {
    int ans = 0;
    for (; i > 0; i -= i & -i) ans += bit[i];
    return ans;
}

public List<Integer> countSmaller1(int[] nums) {
	
    int[] tmp = nums.clone();
    Arrays.sort(tmp);
    for (int i = 0; i < nums.length; i++) {
    	nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
    	System.out.println(i+" "+nums[i]);
    }
    	
    int[] bit = new int[nums.length + 1];
    Integer[] ans = new Integer[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
        ans[i] = query(bit, nums[i] - 1);
        add(bit, nums[i], 1);
    }
    for(int j=0;j<nums.length;j++) {
    	System.out.println(ans[j]);
    }
    return Arrays.asList(ans);

}

	public static void main(String[] args) {
		int[] num= {5,2,6,1};    //2 1 1 0
		// countSmaller(num);
		 
		 SmallerNOAfterSelf315 s=new SmallerNOAfterSelf315();
		 s.countSmaller1(num);

	}

}
