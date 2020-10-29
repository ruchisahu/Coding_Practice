import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {
	 static void printNGE(int arr[], int n)  
	    { 
	        int i = 0; 
	        Stack<Integer> s = new Stack<Integer>(); 
	        //s.peek()=-1;
	        int element, next; 
	  
	        /* push the first element to stack */
	        s.push(arr[0]); 
	  
	        // iterate for rest of the elements 
	        for (i = 1; i < n; i++)  
	        { 
	            next = arr[i]; 
	  
	            if (s.isEmpty() == false)  
	            { 
	                  
	                // if stack is not empty, then  
	                // pop an element from stack 
	                element = s.pop(); 
	  
	                while (element < next)  
	                { 
	                    System.out.println(element + " --> " + next); 
	                    if (s.isEmpty() == true) 
	                        break; 
	                    element = s.pop(); 
	                } 
	  
	                /* If element is greater than next, then  
	                   push the element back */
	                if (element > next) 
	                    s.push(element); 
	            } 
	  
	            /* push next to stack so that we can find next 
	               greater for it */
	            s.push(next); 
	        } 
	  
	        while (s.isEmpty() == false)  
	        { 
	            element = s.pop(); 
	            next = -1; 
	            System.out.println(element + " -- " + next); 
	        } 
	    }  

	public static void main(String[] args) {
		int arr[]= {1, 13, 2, 4}; 
        int n = arr.length; 
        printNGE(arr, n); 

	}

}
