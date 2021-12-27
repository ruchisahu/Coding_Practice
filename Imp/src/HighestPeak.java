import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HighestPeak {
    private static class HPNode {
        int x;
        int y;
        int nextValue;
        HPNode(int x, int y, int nextValue){
            this.x = x;
            this.y = y;
            this.nextValue = nextValue;
        }
    }

    public static int findHighestPeak(boolean[][] map){
        if(map == null || map.length == 0 || map[0].length == 0) return 0;
        int row = map.length, col = map[0].length;

        Queue<HPNode> q = new LinkedList<>();
        boolean[][] seen = new boolean[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(map[i][j]){
                    q.add(new HPNode(i,j,0));
                    seen[i][j] = true;
                }
            }
        }

        int max = 0;
        while(!q.isEmpty()){
            HPNode next = q.poll();
            max = Math.max(max, next.nextValue);

            List<int[]> neis = getNei(row, col, next.x, next.y);
            for(int[] nei : neis) {
                if (!seen[nei[0]][nei[1]]) {
                    q.add(new HPNode(nei[0], nei[1],next.nextValue + 1));
                    seen[nei[0]][nei[1]] = true;
                }
            }

        }
        return max;
    }

    public static List<int[]> getNei(int row, int col, int i, int j){
        List<int[]> list = new ArrayList<>();
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};

        for(int[] dir : dirs){
            if(i + dir[0] >= 0 && j + dir[1] >= 0 && i + dir[0] < row && j + dir[1] < col){
                list.add(new int[]{i + dir[0], j + dir[1]});
            }
        }
        return list;
    }

    public static void main(String args[]){
        boolean[][] map = new boolean[][]{{true,false,true},{false,false,false},{false,false,false}};
        System.out.println(findHighestPeak(map));
    }

}
