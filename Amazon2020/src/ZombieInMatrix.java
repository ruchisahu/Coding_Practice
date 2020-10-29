//https://leetcode.com/problems/rotting-oranges/
/*
 * 
 * Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right) human beings 
into 
zombies every hour. Find out how many hours does it take to infect all humans?

Example:

Input:
[[0, 1, 1, 0, 1],
 [0, 1, 0, 1, 0],
 [0, 0, 0, 0, 1],
 [0, 1, 0, 0, 0]]

Output: 2

Explanation:
At the end of the 1st hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [0, 1, 0, 1, 1],
 [1, 1, 1, 0, 1]]

At the end of the 2nd hour, the status of the grid:
[[1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1],
 [1, 1, 1, 1, 1]]
*/
import java.util.*;
public class ZombieInMatrix
{
//my solution working, time exceed on Aone compiler
	public static int minHours(int rows, int columns, int[][] grid)  //need to test with List<List<Integer>> grid
	{
		int[][] grid2=new int[grid.length][grid[0].length];
		int count=0;
		while(!notAllZombie(grid))
		{
			for(int i=0;i <grid.length;i++)
			{
				for(int j=0;j<grid[0].length;j++)
				{
					grid2[i][j]=grid[i][j];
				}
			}
			
			for(int i=0;i <grid.length;i++)
			{
				for(int j=0;j<grid[0].length;j++)
				{
					if(grid[i][j]==1)
					{
						if(i>0)
						{
							grid2[i-1][j]=1;
						}
						if(i<grid.length-1)
						{
							grid2[i+1][j]=1;
						}
						
						if(j<grid[0].length-1)
						{
						grid2[i][j+1]=1;
						}
						
						if(j>0)
						{
						grid2[i][j-1]=1;
						}
					}
				}
			}
			for(int i=0;i <grid.length;i++)
			{
				for(int j=0;j<grid[0].length;j++)
				{
					grid[i][j]=grid2[i][j];
				}
			}
			count++;
				
			
				
		}
		return count;
	}
	private static boolean notAllZombie(int[][] grid) 
	{
		for(int i=0;i <grid.length;i++)
		{
			for(int j=0;j<grid[0].length;j++)
			{
				if(grid[i][j]!=1)
				{
					return false;
				}
			}
		}
		
		return true;
	}
	
	//all testcase pass
	public int humanDays(int[][] grid) {
		   Queue<int[]> q = new LinkedList<>();
		int target = grid.length * grid[0].length;
		int cnt = 0, res = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(grid[i][j] == 1) {
					q.offer(new int[] {i,j});
					cnt++;
				}
			}
		}
		int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		while(!q.isEmpty()) {
			int size = q.size();
			if(cnt == target)
				return res;
			for(int i=0;i<size;i++) {
				int[] cur = q.poll();
				for(int[] dir : dirs) {
					int ni = cur[0] + dir[0];
					int nj = cur[1] + dir[1];
					if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
						cnt++;
						q.offer(new int[] {ni, nj});
						grid[ni][nj] = 1;
					}
				}
			}
			res++;
		}
		return -1;
	}
	public static void main(String[] args) {
		
		int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		
		System.out.println(minHours(grid.length, grid[0].length,grid));

	}

}
/*
 * public int minHours(List<List<Integer>> grid) {

    int people = 0;

    Queue<Point> zombies = new ArrayDeque<>();

    for (int r = 0; r < grid.size(); r++) {

        for (int c = 0; c < grid.get(0).size(); c++) {

            if (grid.get(r).get(c) == ZOMBIE) {

                zombies.add(new Point(r, c));

            } else {

                people++;

            }

        }

    }



    if (people == 0) return 0;



    for (int hours = 1; !zombies.isEmpty(); hours++) {

        for (int sz = zombies.size(); sz > 0; sz--) {

            Point zombie = zombies.poll();



            for (int[] dir : DIRS) {

                int r = zombie.r + dir[0];

                int c = zombie.c + dir[1];



                if (isHuman(grid, r, c)) {

                    people--;

                    if (people == 0) return hours;

                    grid.get(r).set(c, ZOMBIE);

                    zombies.add(new Point(r, c));

                }

            }

        }

    }

    return -1;

}



private boolean isHuman(List<List<Integer>> grid, int r, int c) {

    return r >= 0 && r < grid.size() &&c >= 0 && c < grid.get(0).size() && grid.get(r).get(c) != ZOMBIE;

}



private static class Point {

    int r, c;

    Point(int r, int c) {

        this.r = r;

        this.c = c;

    }

}
 
*/