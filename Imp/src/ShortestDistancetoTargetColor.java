import java.util.*;

public class ShortestDistancetoTargetColor {
    public static List<Integer> shortestPath(int[] colors,int[][] queries){
        List<Integer> res = new ArrayList<>();
        if(colors == null || colors.length == 0) return res;

        for(int i = 0; i < queries.length; i++){
            int temp = helper(queries[i],colors);
            res.add(temp);
        }

        return res;
    }

    public static int helper(int[] query,int[] colors){
        int index = query[0];
        int left = query[0];
        int right = query[0];
        int color = query[1];

        while(left >= 0 || right < colors.length){
            if(left >= 0 && colors[left] == color){
                return index - left;
            }else if(right < colors.length && colors[right] == color){
                return right - index ;
            }else{
                left--;
                right++;
            }
        }

        return -1;
    }

    public static void main(String args[]){
        int[] colors = new int[]{1,1,2,1,3,2,2,3,3};
        int[][] queries = new int[][]{{1,3},{2,2},{6,1}};

        System.out.println(shortestPath(colors,queries));
    }
}
