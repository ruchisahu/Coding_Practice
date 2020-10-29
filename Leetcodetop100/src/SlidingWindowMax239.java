import java.util.*;


public class SlidingWindowMax239 {
	//time limit exceed
public static int[] maxSlidingWindow1(int[] nums, int k) 
{
	int len=nums.length;
	  int[] result=new int[len-k+1];
     
  
     int start =0;
     int end=start+k-1;
     while(end<len)
     {
     PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		for(int i=start;i<=end;i++) 
		{
			
			pq.offer(nums[i]);
		}
		result[start]=pq.poll();
		System.out.println(result[start]);
		start++;
		end++;
     }
     return result;
}



public static int[] maxSlidingWindowmx3(int[] nums, int k) {
    
    int len=nums.length;
     int[] result=new int[len-k+1];
     if (nums.length <2)
     return result;
     
    Minmax mm = new Minmax(nums,k);
   
       
      result[0] = nums[mm.maxind];  
     for ( int i=k;i <nums.length;i++)
     {
    	 result[i-k+1] = nums[mm.ComputeMax(i-k, i)];
    	 
    	 System.out.println("i :"+i+", k :"+k +", i-k = "+ (i-k));
          
     }

 
        
     return result;
    }




public static int[] maxSlidingWindow(int[] nums, int k) {
    
    int len=nums.length;
     int[] result=new int[len-k+1];
     
   System.out.println("result length: "+(len-k+1));
     int start =0;
     int end=start+k-1;
     Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        
     int i =0 ; 
     for (i = 0 ; i < k ; i++)
     {
         pq.offer(nums[i]);
     }
       
        
     for ( ;i <nums.length;i++)
     {
         System.out.println("i :"+i+", k :"+k +", i-k = "+ (i-k));
         result[i-k]=pq.peek();
         
         pq.remove(nums[i-k]);
         pq.offer(nums[i]);
         
     }
     result[i-k]=pq.peek();
        
        
/*
        
     while(end<len)
     {
    // PriorityQueue<Integer> pq =new PriorityQueue<>((x, y) -> Integer.compare(y, x));
         
         
		for(int i=start;i<=end;i++) 
		{
			pq.offer(nums[i]);
		}
		result[start]=pq.poll();
		//System.out.println(result[start]);
		start++;
		end++;
     }
     */
     return result;
    }

	public static void main(String[] args) {
		System.out.println("test");
		int[] nums = {1,3,-1,-3,5,3,6,7};//3 3 5 5 6 6 7
		 int k = 3;
		// maxSlidingWindow1(nums, k);
		 maxSlidingWindow(nums, k);

	}
}



