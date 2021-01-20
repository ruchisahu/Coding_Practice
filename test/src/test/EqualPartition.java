package test;

import java.util.*;

public class EqualPartition {
	 public static boolean canPartition(int[] nums) {
		 int sum = 0;
		    for(int i = 0; i < nums.length; i++) {
		        sum += nums[i];
		    }
		    
		    if(sum %2 != 0) return false;
		 List<Integer>list=new ArrayList<>();
		 list.add(0);
		 int t=sum/2;
		 for(int num:nums) {
			 int m=list.size();
		 for(int l=0;l<m;l++) {
			 if(list.get(l)+num==t) {
				 System.out.println("sum="+list.get(l)+num);
				 return true;
			 }
				 list.add(list.get(l)+num);
				 System.out.println(l+num);
			 }
		 }
		 return true;
	 }

	public static void main(String[] args) {
		int[] num= {1,5,11,5};
		 System.out.println(canPartition(num));

	}

}
