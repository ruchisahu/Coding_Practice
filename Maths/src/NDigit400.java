//https://leetcode.com/problems/nth-digit/
//leetcode.com/problems/nth-digit/discuss/992320/Sol-Using-Math..-Explained-in-Great-Detail..-Please-Upvote-if-you-Like.
public class NDigit400 {

    public static int findNthDigit(int n) {
    	if(n<10)return n;
    	int count=0;
    	int i=1;
    	
    	while(true) {
    		count+=i*Math.pow(10, i-1)*9;
    		if(count>=n)break;
    		i++;
    	}
    	count-=i*Math.pow(10, i-1)*9;
    	n-=count;
    	
		return n;
        
    }

	public static void main(String[] args) {
		findNthDigit(11);

	}

}
