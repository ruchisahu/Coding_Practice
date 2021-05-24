import java.util.*;

public class FriendConnection {
	 public static int findCircleNum(int[][] M) {
	        UF uf = new UF(M.length);
	        
	        for (int i=0; i<M.length - 1; i++) {
	            for (int j=i+1; j<M.length; j++) {
	                if (M[i][j] == 1)
	                    uf.union(i, j);
	            }
	        }
	        return uf.getComponent();
	    }
	 public static void main(String[] args) {
			// TODO Auto-generated method stub

		
	 int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
	 System.out.println(findCircleNum(isConnected));  //2
	 
	 int[][] isConnected1 = {{1,0,0},{0,1,0},{0,0,1}};
	 System.out.println(findCircleNum(isConnected1));   //3
	 }
	}

