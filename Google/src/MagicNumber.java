
public class MagicNumber {
	public boolean isMagicNumber(String s) {
		return check(s, s.length());
		
	}

	/*Given a sequence of numbers, find if the sequence is a magic sequence or not.
	A sequence is said to be a magic sequence if it is able to satisfy the condition that the number is the sum of preceding to numbers and follows the pattern till the end.
	Examples

	123 -> yes 1+2 = 3
	1231518 -> yes 12+ 3 = 15 , 3+ 15 = 18
	12314374 -> yes 12+31 =43 , 31+43 = 74
	1231124125 -> yes 123+ 1 = 124, 1+ 124=125

	1237 -> no 1+2=3, 2+3 != 7
	456515727 -> no 45+6=51, 6+51=57, 52+57 != 27*/

	public boolean check(String s,int end) {
		if(end<3) return false;
		
		for(int pos=end-1;pos>=0;pos--) { //choose a target substring from pos to end 
			
			int idx=breakRemainingString(s.substring(pos,end),s,pos); 
			if(idx==-1) continue; //number cannot be formed
			else if(idx==0) return true; //string exhausted
			
			boolean temp= check(s,pos);//recursive check remaining substring
			
			if(temp) return true;
			
		}
		return false;
		
	}

	public int breakRemainingString(String target,String s,int end) { //try forming target from s(0,end) by breaking into two
	     for(int i=end-1;i>=0;i--) { //first partition
	    	 for(int j=i-1;j>=0;j--) {//second partition
	    		 int first= Integer.parseInt(s.substring(i,end));
	    		 int second= Integer.parseInt(s.substring(j,i));
	    		 int t= Integer.parseInt(target);
	    		 
	    		 if(first+second==t) return j;
	    	 }
	     }
	     return -1;

	}

	public static void main(String args[]) {
		MagicNumber st= new MagicNumber();
		
		String s="456515727";
		System.out.println(st.isMagicNumber(s));
	}
}

