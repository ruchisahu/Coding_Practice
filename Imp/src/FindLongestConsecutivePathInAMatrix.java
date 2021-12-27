import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindLongestConsecutivePathInAMatrix {
    public static List<Integer> find(int[] start, int[][] grid) {
        List<Integer> res = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) return res;

        int[][] dirs = new int[][]{{-1,0},{0,-1},{1,0},{0,-1}};
        int row = grid.length, col = grid[0].length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = start[0]; i < row; i++) {
            for (int j = start[1]; j < col; j++) {
                List<Integer> list = helper(grid, i, j, map, dirs);
                if(res.size() < list.size()){
                    res.clear();
                    res.addAll(list);
                }
            }
        }
        return res;
    }

    public static List<Integer> helper(int[][] grid, int row, int col, HashMap<Integer, List<Integer>> map, int[][] dirs) {

        if(map.containsKey(grid[row][col])) return map.get(grid[row][col]);
        List<Integer> thisList = new ArrayList<>();
        thisList.add(grid[row][col]);
        List<Integer> max = new ArrayList<>();

        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length){
                if(grid[nextRow][nextCol] - 1 == grid[row][col]){
                    List<Integer> nextList = helper(grid, nextRow, nextCol, map, dirs);
                    if(!nextList.isEmpty() && nextList.size() > max.size()){
                        max.clear();
                        max.addAll(nextList);
                    }
                }
            }
        }

        thisList.addAll(max);
        map.put(grid[row][col],thisList);
        return thisList;
    }

    public static void main(String args[]){
        int[][] grid = new int[][]{{1,2,13,5},
                                    {11,10,9,6},
                                    {3,4,8,7},
                                    {12,14,15,16}};
        int[] start = new int[]{0,3};

        System.out.println(find(start,grid));
    }
}
