import java.util.*;

public class ShortestBridge934 {
	int flag=0;
	Set<point> set1=new HashSet<>();
	Set<point>set2=new HashSet<>();
public int shortestBridge(int[][] A) {
	
	boolean[][] visited= new boolean[A.length][A[0].length];
	
	for(int row=0;row<A.length;row++) {
		for(int col=0;col<A[0].length;col++) {
			if(A[row][col]==1 && flag==0) {
				dfs(A,row,col,set1,visited);
				 flag=1;
			}
			else {
				dfs(A,row,col,set2,visited);
			}
		}
	}
	int Mindis=Integer.MAX_VALUE;
	for(point p1:set1) {
		for(point p2:set2) {
			int dis=(Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y))-1;
			Mindis=Math.min(Mindis,dis );
		}
	}
	
	return Mindis;
        
    }

	private void dfs(int[][] a, int row, int col,Set<point> set,boolean[][] visited) {
	  
	   if(row<0 || col<0 || row>=a.length || col>=a[0].length ||visited[row][col] || a[row][col] == 0)return;
	   visited[row][col]=true;
	   
	   set.add(new point(row,col));
	   System.out.println("set:"+flag+"   "+row+" "+col);
	   dfs(a,row-1,col,set,visited);
	   dfs(a,row,col-1,set,visited);
	   dfs(a,row+1,col,set,visited);
	   dfs(a,row,col+1,set,visited);
	   
	   
	   
	
	
}

	public static void main(String[] args) {
		ShortestBridge934 s=new ShortestBridge934();
		int[][] A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
	//	System.out.println(s.shortestBridge(A));   //1
		
		int[][]A1 = {{0,1},{1,0}};
		System.out.println(s.shortestBridge(A1));   //1

	}
	
	class point{
		int x;
		int y;
		point(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

}
