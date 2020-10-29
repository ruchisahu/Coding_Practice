package robertSedwick;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DeadEnd {

	public static void main(String[] args) 
	{
		 In in = new In("C:\\Users\\sankalpg\\eclipse-workspace3\\robertSedwick\\src\\robertSedwick\\test2.txt");
	        Graph G = new Graph(in);
	        
	        StdOut.println(G);
	        for(int i=1;i<=8;i++)
	        {
	        	if(G.degree(i)<2)
	        	{
	          //  StdOut.println("degree of"+i+"  =  "+G.degree(i) +"road" );
	        	for (int w : G.adj[i]) 
	                System.out.println(i+"->"+w + " ");
	        	
	            }
	        }

	}

}
