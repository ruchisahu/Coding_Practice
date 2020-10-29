
public class StairCase {
	 public static int climbStairs(int n) {
	        
	        int[] count=new int[n+1];
	        count[0]=1;
	        count[1]=1;
	        for(int i=2;i<=n;i++){
	            count[i]=count[i-1]+count[i-2];
	        }
	        return count[n];
	    }

	public static void main(String[] args) {
		System.out.println(climbStairs(3));

	}

}
