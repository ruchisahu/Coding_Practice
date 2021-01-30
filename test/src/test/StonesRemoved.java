package test;

import java.util.*;
//947 leetcode
public class StonesRemoved {
	public static int removeStones(int[][] stones) {
	       
	       int n=stones.length;
	       int[] parent=new int[n];
	       for(int i=1;i<n;i++) {
	    	   parent[i]=i;
	       }
	       int component=n;
	  
	       for(int i=0;i<n;i++) {
	    	   for(int j=i+1;j<n;j++) {
	    		   if(stones[i][0]!=stones[j][0] && stones[i][1]!=stones[j][1])continue;
	    		   
	    		   int rootI=findRoot(parent,i);
	    		   int rootJ=findRoot(parent,j);
	    		   if(rootI==rootJ) {
	    			   continue;
	    			   }
	    		   else {
	    			   parent[rootI]=rootJ;
	    			   component--;
	    		   }
	    		   
	    	   }
	    	  
	       }
	       
		return n-component;
	    }

	private static int findRoot(int[] parent, int i) {
		while(i!=parent[i]) {
			parent[i]=parent[parent[i]];
			i=parent[i];
		}
		// TODO Auto-generated method stub
		return i;
	}

	public static void main(String[] args) {
		int[][] stones= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println(removeStones(stones));

	}

}
