import java.util.ArrayList;
import java.util.List;

public class FindSquare {
    public static List<Integer> findStartPoint(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();

        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-1);
        int res = 0;

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i - 1][j - 1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    if(res < dp[i][j]) {
                        res = dp[i][j];
                        // res is the length and width,from res we can find the left top's coordinates
                        list.set(0,i - (res - 1));
                        list.set(1,j - (res - 1));
                    }
                }
            }
        }
        return list;
    }

    // 找最大正方形
    // 如果就是找一个正方形，就不需要做res < dp[i][j]，当dp[i][j] = 2 的时候，就说明是一个正方形了，因为正方形是有1组成的
    public static int findArea(int[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];

        int res = 0;

        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i - 1][j - 1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j],dp[i][j - 1]),dp[i - 1][j - 1]) + 1;
                    if(res < dp[i][j]) {
                        res = dp[i][j];
                    }
                }
            }
        }
        return res * res;
    }

    public static void main(String args[]){
        int[][] matrix = new int[][]{{1,0,1,0,0},
                                     {1,0,1,1,1},
                                     {1,1,1,1,1},
                                     {1,0,1,1,1}};

        System.out.println(findStartPoint(matrix));
        //System.out.println(findArea(matrix));
    }
}
