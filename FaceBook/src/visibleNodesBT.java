import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class visibleNodesBT {
	
	  class Node {
	    int data; 
	    Node left; 
	    Node right; 
	    Node() {
	      this.data = 0; 
	      this.left = null; 
	      this.right = null; 
	    }
	    Node(int data) {
	      this.data = data; 
	      this.left = null; 
	      this.right = null; 
	    }
	  }
	  
	  // Add any helper functions you may need here
	  

	  int visibleNodes(Node root) {
		  Queue<Node> visibleNode=new LinkedList<>();
		  List<Node> list=new ArrayList<>();
		  visibleNode.add(root);
		  list.add(root);
		  
		  while(!visibleNode.isEmpty()) {
			  int size=visibleNode.size();
			  boolean flag=true;
			  for(int i=0;i<size;i++) {
				  Node curr=visibleNode.poll();
				  if(curr.left!=null) {
					  if(flag==true) {
						  flag=false;
						  list.add(curr.left);
					  }
					  visibleNode.add(curr.left);
				  }
				  if(curr.right!=null) {
					  if(flag==true) {
						  flag=false;
						  list.add(curr.right);
					  }
					  visibleNode.add(curr.right);
				  }
				  
			  }
		  }
		  
		return list.size();
	    // Write your code here
	    
	  }












	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom, but they are otherwise not editable!
	  int test_case_number = 1;
	  void check(int expected, int output) {
	    boolean result = (expected == output);
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printInteger(expected); 
	      System.out.print(" Your output: ");
	      printInteger(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printInteger(int n) {
	    System.out.print("[" + n + "]");
	  }
	  public void run() throws IOException {
	    
	    Node root_1 = new Node(8); 
	    root_1.left = new Node(3); 
	    root_1.right = new Node(10); 
	    root_1.left.left = new Node(1); 
	    root_1.left.right = new Node(6); 
	    root_1.right.right = new Node(14); 
	    root_1.left.right.left = new Node(4); 
	    root_1.left.right.right = new Node(7); 
	    root_1.right.right.left = new Node(13); 
	    int expected_1 = 4;
	    int output_1 = visibleNodes(root_1);
	    check(expected_1, output_1);

	    Node root_2 = new Node(10); 
	    root_2.left = new Node(8);
	    root_2.right = new Node(15);
	    root_2.left.left = new Node(4);
	    root_2.left.left.right = new Node(5);
	    root_2.left.left.right.right = new Node(6);
	    root_2.right.left = new Node(14);
	    root_2.right.right = new Node(16);

	    int expected_2 = 5;
	    int output_2 = visibleNodes(root_2);
	    check(expected_2, output_2);
	  
	    // Add your own test cases here
	    
	  }
	  public static void main(String[] args) throws IOException {
	    new visibleNodesBT().run();
	  }
	}