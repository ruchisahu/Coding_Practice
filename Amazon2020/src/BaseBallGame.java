import java.util.*;

//https://leetcode.com/problems/baseball-game/
public class BaseBallGame {
	 public static int calPoints(String[] ops) {
	        
	        int total=0;
	        Stack<String>record=new Stack<>();
	        
	        for(int i=0;i<ops.length;i++){
	            
	            if(ops[i].equals("C")){
	                record.pop();
	            }else if(ops[i].equals("D")){
	                int poppedNum= Integer.parseInt(record.pop());
	                int newScore=2*poppedNum;
	                record.push(String.valueOf(poppedNum));
	                record.push(String.valueOf(newScore));
	                
	            }else if(ops[i].equals("+")){
	                int numOne=Integer.parseInt(record.pop());
	                int numTwo=Integer.parseInt(record.pop());
	                int newNum=numOne+numTwo;
	                record.push(String.valueOf(numTwo));
	                record.push(String.valueOf(numOne));
	                record.push(String.valueOf(newNum));
	            }else{
	                record.push(ops[i]);
	            }
	            
	        }
	        
	        while(!record.isEmpty()){
	            total+=Integer.parseInt(record.pop());
	        }
	        
	        
	        return total;
	    }
	

	public static void main(String[] args) {
		String[] ops = {"5","2","C","D","+"};
		calPoints(ops);

	}

}
