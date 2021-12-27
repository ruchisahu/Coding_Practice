import java.util.ArrayList;
import java.util.List;

/* Leetcode 286
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 2 31 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:

3  -1   0   1
2   2   1  -1
1  -1   2  -1
0  -1   3   4
 */
public class WallsAndGates {
    public static int[][] wallAndGates(int[][] grid){
        if(grid == null || grid.length == 0 || grid[0].length == 0) return grid;

        int row = grid.length, col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0) {
                    helper(grid, i, j, 0);
                }
            }
        }
        return grid;
    }

    public static void helper(int[][] grid, int row, int col, int val){
        // 因为要找最近的门，所以当当前的值小于深度值时，不需要更新当前值，所以grid[row][col] < val要返回，
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] < val) return;

        grid[row][col] = val;

        helper(grid, row + 1, col, val + 1);
        helper(grid, row - 1, col, val + 1);
        helper(grid, row, col + 1, val + 1);
        helper(grid, row, col - 1, val + 1);
    }

    public static void main(String args[]){
        int[][] grid = new int[][]{ {Integer.MAX_VALUE,-1,0,Integer.MAX_VALUE},
                                    {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,-1},
                                    {Integer.MAX_VALUE,-1,Integer.MAX_VALUE,-1},
                                    {0,-1,Integer.MAX_VALUE,Integer.MAX_VALUE}};
        int[][] res = wallAndGates(grid);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < res.length;i++){
            for(int j = 0; j < res[0].length; j++){
                list.add(grid[i][j]);
            }
            System.out.println(list);
            list = new ArrayList<>();
        }

    }
}
