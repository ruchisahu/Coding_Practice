import java.util.PriorityQueue;

public class CampusBikes2 {
    static int min = Integer.MAX_VALUE;
    public static int campusBike2(int[][] workers, int[][] bikes){
        if(workers == null || bikes == null) return -1;

        boolean[] seen = new boolean[bikes.length];
        dfs(seen, workers, 0, bikes, 0);
        return min;
    }

    public static void dfs(boolean[] seen,int[][] workers, int index, int[][] bikes, int dis){
        if(index == workers.length){
            min = Math.min(min,dis);
            return;
        }

        if(dis > min) return;

        for(int j = 0; j < bikes.length; j++) {
            if (seen[j]) continue;
            seen[j] = true;
            dfs(seen, workers, index + 1, bikes, dis + getDis(workers[index], bikes[j]));
            seen[j] = false;
        }
    }

    public static int getDis(int[] x, int[] y){
        return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
    }

    public static void main(String args[]){
        int[][] workers = new int[][]{{0,0},{2,1}};
        int[][] bikes = new int[][]{{1,2},{3,3}};

        System.out.println(campusBike2(workers,bikes));

    }
}
