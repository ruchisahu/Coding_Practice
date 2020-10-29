
public class DecodeWays91 {
	 public static int numDecodings(String s) {
	     int n = s.length();
	        if(n==0) return 0;
	        int ways[] = new int[n+1];
	         
	        ways[0]=1;
	        ways[1] = s.charAt(0) !='0' ? 1:0;
	        for(int i=2; i<=n; i++){
	            if(s.charAt(i-1) !='0'){
	                ways[i] = ways[i-1];
	            }
	            int val = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
	            if(val<=26 && val>=10){
	                ways[i] += ways[i-2];
	            }
	        }
	        return ways[n];   
	    }
	public static void main(String[] args) {
		System.out.println(numDecodings("226"));

	}

}
