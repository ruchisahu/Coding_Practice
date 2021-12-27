import java.util.LinkedList;
import java.util.Queue;
// leetcode 490
public class TheMaze {
    public static boolean isPossiable(int[][] maze,int[] start,int[] end){
        if(maze == null || maze.length == 0) return false;

        int row = maze.length, col = maze[0].length;
        boolean[][] seen = new boolean[row][col];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        seen[start[0]][start[1]] = true;

        while(!q.isEmpty()){

            int[] index = q.poll();
            int x = index[0];
            int y = index[1];

            if(x == end[0] && y == end[1]) return true;

            for(int[] dir : dirs){
                // 球要一直走到遇到墙，不能停在中间空白的地方
                while(x >= 0 && x < row && y >= 0 && y < col && maze[x][y] == 0){
                    x = x + dir[0];
                    y = y + dir[1];
                }
                // 如果遇到墙，就往回走一格
                x = x - dir[0];
                y = y - dir[1];
                if(!seen[x][y]){
                    seen[x][y] = true;
                    q.add(new int[]{x,y});
                }
            }

        }
        return false;
    }

    public static void main(String args[]){
        int[][] maze = new int[][]{
                                    {0,0,1,0,0},
                                    {0,0,0,0,0},
                                    {0,0,0,1,0},
                                    {1,1,0,1,1},
                                    {0,0,0,0,0}
                                    };
        int[] start = new int[]{0,4};
        int[] end = new int[]{3,2};
        System.out.println(isPossiable(maze,start,end));
    }
}
