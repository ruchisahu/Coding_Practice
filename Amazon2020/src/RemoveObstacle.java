/*
 * https://leetcode.com/discuss/interview-question/396858/amazon-oa-minimum-distance-to-remove-obstacle
 * You are in charge of preparing a recently purchased lot for Amazon’s building.
 *  The lot is covered with trenches and has a single obstacle that needs to be taken down 
 *  before the foundation is prepared for the building. The demolition robot must remove the obstacle 
 *  before the progress can be made on the building. 
 *  Write an algorithm to determine the minimum distance required for the demolition robot
 *   to remove the obstacle

Input: The input of the function has 3 arguments:

numRows – number of rows
numColumns – number of columns
lot – 2d grid of integers

Example: numRows = 3,
numColumns = 3
lot = [
[1, 0, 0],
[1, 0, 0],
[1, 9, 1]
]

This is a very common breadth first serach problem however the grid was given as a list of integer(List<List> lot) rather than a 2D array. 
I was very confused on how to convert it to a 2d array. Can someone please suggest.
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RemoveObstacle {
public static void main(String[] args) {
		
		List<Integer> ls1  = new ArrayList<>();
		ls1.add(1);
		ls1.add(0);
		ls1.add(1);
		ls1.add(0);
		
		List<Integer> ls2  = new ArrayList<>();
		ls2.add(1);
		ls2.add(0);
		ls2.add(0);
		ls2.add(1);
		
		List<Integer> ls3  = new ArrayList<>();
		ls3.add(1);
		ls3.add(1);
		ls3.add(9);
		ls3.add(0);
		
		
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(ls1);
		list.add(ls2);
		list.add(ls3);
		
		int rows = list.size();
		int columns= list.get(0).size();
		
		int shortestDistannce = getDistance(list,rows,columns);
		System.out.println(shortestDistannce);
		
	}

	private static int getDistance(List<List<Integer>> list, int rows, int columns) {
		// TODO Auto-generated method stub
		 boolean[][] visited = new boolean[rows][columns];
		 Queue<Node>q = new LinkedList<Node>();
		 q.add(new Node(0, 0, 0));
		 visited[0][0]=true;
		 while(!q.isEmpty())
		 {
			 Node top = q.poll();
			 visited[top.x][top.y]=true;
			 if(list.get(top.x).get(top.y)==9)
			 {
				 return top.dist-1;
			 }
			 
			 if(top.x+1<list.size() && list.get(top.x+1).get(top.y)!=0 && !visited[top.x+1][top.y])
			 {
				 q.add(new Node(top.x+1,top.y,top.dist+1));
			 }
			 if(top.x-1>0 && list.get(top.x-1).get(top.y)!=0 && !visited[top.x-1][top.y])
			 {
				 q.add(new Node(top.x-1,top.y,top.dist+1));
			 }
			 if(top.y-1>0 && list.get(top.x).get(top.y-1)!=0 && !visited[top.x][top.y-1])
			 {
				 q.add(new Node(top.x,top.y-1,top.dist+1));
			 }
			 if(top.y+1<list.get(0).size() && list.get(top.x).get(top.y+1)!=0 && !visited[top.x][top.y+1])
			 {
				 q.add(new Node(top.x,top.y+1,top.dist+1));
			 }
			 
		 }
		 
		return -1;
	}
	
}

class Node {
    public int x;
    public int y;
    public int dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
