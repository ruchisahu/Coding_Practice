
public class StringCompression {
	//my brute force
     public static int compress(char[] chars) {
    	 StringBuilder sb=new StringBuilder();
    	 int len=0;
    	 for(int i=0;i<chars.length;i++) {
    		 int count=1;
    		 while(i<chars.length-1 && chars[i]==chars[i+1]) {
    			 count++;
    			 i++;
    		 }
    		 if(count==1) {
    			 sb.append(chars[i]);
    		 }
    		 else
    		 {
    			 sb.append(chars[i]).append(count); 
    		 }
    		 
    	 }
    	 System.out.println(sb);
    	 if(sb.toString().length()>chars.length) {
    		 len=chars.length;
    	 }
    	 else {
    		 len=sb.toString().length();
    	 }
		return len;
    	 
     }
        
    //improvement
     public static int compress1(char[] chars) {
    	 int count = 1; 
    	    int index = 0; 
    	    for (int i = 0; i < chars.length; i++) {
    	        while (i < chars.length - 1 && chars[i] == chars[i + 1]) {
    	            count++; 
    	            i++; 
    	        }
    	        if (count == 1) {
    	            chars[index++] = chars[i]; 
    	        } else {
    	            chars[index++] = chars[i]; 
    	            String num = String.valueOf(count); 
    	            for (int j = 0; j < num.length(); j++) {
    	                chars[index++] = num.charAt(j); 
    	            }
    	        }
    	        count = 1; 
    	    }
    	    return index; 
    	 
     } 

	public static void main(String[] args) {
		char[] chars = {'a','a','b','b','c','c','c'};
				System.out.println(compress(chars));

	}

}
