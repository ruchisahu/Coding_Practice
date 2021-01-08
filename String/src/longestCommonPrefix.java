
public class longestCommonPrefix {
	 public static String longestCommonPrefix(String[] strs) {
		 if(strs==null || strs.length==0  ) return "";
         if(strs.length==1) return strs[0];   
		 String prev=strs[0];
	        for(int i=1;i<strs.length;i++){
	            String curr=strs[i];
	             prev=CommonPrefix(curr, prev);
	            
	            
	        }
	        return prev;
	    }
	    
	     public static String CommonPrefix(String curr, String prev){
	         int i=0;
	         while(i<prev.length() && i<curr.length() && curr.charAt(i)==prev.charAt(i)){
	             i++;
	         }
	         return prev.substring(0, i);
	     }
	

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(strs));

	}

}
