import java.util.*;

public class FindKClosestElements658 {
	
	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
	     Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
	     arr = arr.subList(0, k);
	     Collections.sort(arr);
	     return arr;
	}
	//error
	public List findClosestElements(int[] arr, int k, int x) {

	    List<Integer> ans=new ArrayList<>();
	    
	    PriorityQueue<Node> q=new PriorityQueue<>((a,b)->{
	        
	            if(a.diff==b.diff){
	                return a.tick-b.tick;
	            }
	        
	            return a.diff-b.diff;
	        
	    });
	    
	    
	    for(int i=0;i<arr.length;i++){
	        
	        Node node=new Node(arr[i],Math.abs(arr[i]-x),i);
	        q.offer(node);
	    }
	    
	    while(k>0){
	        ans.add(q.poll().num);
	        k--;
	    }
	    
	    Collections.sort(ans);
	    
	    return ans;
	    
	    
	    
	    
	}

	class Node{
	    
	    public int num;
	    
	    public int diff;
	    
	    public int tick;
	    
	    Node(int num,int diff,int tick){
	        
	        this.num=num;
	        this.diff=diff;
	        this.tick=tick;
	        
	    }
	    
	    
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 3;
		FindKClosestElements658 f=new FindKClosestElements658();
		f.findClosestElements(arr,k,x);

	}

}
