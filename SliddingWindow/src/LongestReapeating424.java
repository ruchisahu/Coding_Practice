
public class LongestReapeating424 {
	 public static int characterReplacement1(String s, int k) {
		 int maxLen = 0;
	        for(int l = 0 ; l<26;l++){
	            char c = (char)('A' + l); //repeated char we are looking for
	            int i = 0, j = 0, count = 0;
	            while(j<s.length()){
	                char cur = s.charAt(j);
	                if(cur != c) count++;
	                
	                //make the substring valid again
	                while(count > k){
	                    if(s.charAt(i) != c) count--;
	                    i++;
	                }
	                
	                //update maximun len
	                maxLen = Math.max(maxLen,j-i+1);
	                j++;
	            }
	        }
	        return maxLen;
	        }
	 public static int characterReplacement(String s, int k) {
		    
		    int len = s.length();
		    int[] count = new int[26];
		    int start = 0, maxCount = 0, maxLength = 0;
		    
		    for (int end = 0; end < len; end ++) {
		        maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
		        while(end - start + 1 - maxCount > k) {
		            count[s.charAt(start) - 'A'] --;
		            start ++;
		        }
		        
		        maxLength = Math.max(maxLength, end - start + 1);
		    }
		    
		    return maxLength;
		}
	public static void main(String[] args) {
		String s="AABABBA";
		int k=1;
		System.out.println(characterReplacement(s,k));
		System.out.println(characterReplacement1(s,k));

	}

}
