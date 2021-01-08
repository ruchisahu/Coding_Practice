import java.util.*;

public class KSmallestPairs {
	 public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	        PriorityQueue<Node>pq=new PriorityQueue<>((a,b)->a.val-b.val);
	        
	        for(int i=0;i<nums1.length;i++){
	            for(int j=0;j<nums2.length;j++){
	               // List<Integer> pair=new ArrayList<Integer>()
	                pq.add(new Node(nums1[i],nums2[j],nums1[i]+nums2[j]));
	            }
	        }
	        List<List<Integer>> result=new ArrayList<List<Integer>>();  
	        while(k>0 && !pq.isEmpty()){
	        	List<Integer> pair=new ArrayList<Integer>();
	        	Node n=pq.poll();
	        	pair.add(n.r);
	        	pair.add(n.c);
	            result.add(pair);
	            System.out.println(n.r+" "+n.c);
	            k--;
	        }
	         return result;
	    }
	
	 class Node{
	        int r;
	        int c;
	        int val;
	        public Node(int r , int c , int val){
	            this.r = r;
	            this.c = c;
	            this.val = val;
	        }
	    }

	public static void main(String[] args) {
		int[] nums1 = {1,7,11};
		int[] nums2 = {2,4,6};
		int k = 3;
		KSmallestPairs K=new KSmallestPairs();
	//	K.kSmallestPairs(nums1,nums2,k); //[[1,2],[1,4],[1,6]] 
		
		int nums11[]= {1,1,2};
		int[] nums21= {1,2,3};
				int k1=10;
				K.kSmallestPairs(nums11,nums21,k1);

	}

}
