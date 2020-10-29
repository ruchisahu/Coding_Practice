import java.util.LinkedList;
import java.util.Queue;

public class friend {
	
	    public static void dfs(int[][] M, int i)
	    {
	        for (int j = 0; j < M.length; j++)
	        {
	            if (M[i][j] == 1)
	            {
	            	System.out.println("i="+i+"j="+j);
	                M[i][j] = M[j][i] = 0;
	                dfs(M, j);
	            }
	        }
	    }
	    public static int findCircleNum(int[][] M) {
	        int count = 0;
	        for (int i = 0; i < M.length; i++) {
	            if (M[i][i] == 1) 
	            {
	                dfs(M, i);
	                count++;
	            }
	        }
	        return count;
	    }
	//other sol
	    public int findCircleNum1(int[][] M) {
	        int count = 0;
	        for (int i=0; i<M.length; i++)
	            if (M[i][i] == 1) { count++; BFS(i, M); }
	        return count;
	    }
	private void BFS(int student, int[][] M)
	{
		 Queue<Integer> queue = new LinkedList<>();
		    queue.add(student);
		    while (queue.size() > 0) {
		        int queueSize = queue.size();
		        for (int i=0;i<queueSize;i++) {
		            int j = queue.poll();
		            M[j][j] = 2; 
		            for (int k=0;k<M[0].length;k++) 
		                if (M[j][k] == 1 && M[k][k] == 1) queue.add(k);
		        }
		    }
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] n={{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(findCircleNum(n));

	}

}
