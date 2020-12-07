import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DinnerPlateStacks1172 {
	int capacity;
	ArrayList<Stack> list=new ArrayList<Stack>();
	   
    public DinnerPlateStacks1172(int capacity) {
        this.capacity = capacity;    
    }
  

    public void push(int val) {
    	int size=list.size();
    	Stack curr=null;
    	if(!list.isEmpty()) {
    		curr=list.get(list.size()-1);}
       
        if(!list.isEmpty() && curr.size()<capacity) {
        	curr.add(val);
        }
        	
        
        else {
        	Stack stack=new Stack();
        	stack.add(val);
        	list.add(stack);
        }
    }

    public int pop() {
    	if(list.size()==0)return -1;
    	Stack curr=list.get(list.size()-1);
    	if(curr==null)return -1;
    	int val=(int) curr.pop();
    	if(curr.size()==0)
    		list.remove(list.size()-1);
		return val;
        
    }

    public int popAtStack(int index) {
    	if(index<0||index>=list.size())return -1;
        if(list.get(index).size()==0)return -1;
		return index;
       
    }





	public static void main(String[] args) {
		
		DinnerPlateStacks1172 D = new DinnerPlateStacks1172(2);  // capacity = 2
		D.push(1);
		D.push(2);
		D.push(3);
		D.push(4);
		D.push(5);
		System.out.println(D.pop());   // Returns 2.  Stack:   4
        
		D.push(20);   
		D.push(21);      
		
		System.out.println(D.pop());   
		System.out.println(D.pop());
		System.out.println(D.pop());            
		System.out.println(D.pop());            
		System.out.println(D.pop()) ;          
		System.out.println(D.pop());         
		System.out.println(D.pop()) ;           


	}

}
	

	

	


