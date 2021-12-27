import java.util.*;

public class MergeIntervalsWithLabels {
    private static class Node{
        char c;
        boolean isAdd;
        Node(char c, boolean isAdd){
            this.c = c;
            this.isAdd = isAdd;
        }
    }

    public static List<String> merge(int[][] intervals, char[] chars){
        if(intervals == null || intervals.length == 0 || chars == null || chars.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();

        TreeMap<Integer,List<Node>> map = new TreeMap<>();

        for(int i = 0; i < intervals.length; i++){
            Node n1 = new Node(chars[i],true);
            Node n2 = new Node(chars[i],false);

            map.putIfAbsent(intervals[i][0], new ArrayList<>());
            map.putIfAbsent(intervals[i][1], new ArrayList<>());

            map.get(intervals[i][0]).add(n1);
            map.get(intervals[i][1]).add(n2);
        }

        HashSet<Character> set = new HashSet<>();
        int pre = 0;

        for(Map.Entry<Integer,List<Node>> e : map.entrySet()){
            if(set.size() > 0){
                res.add("(" + pre + "," + e.getKey() + ")" + ":" + set);
            }
            for(Node n : e.getValue()){
                if(n.isAdd){
                    set.add(n.c);
                }else{
                    set.remove(n.c);
                }
            }
            pre = e.getKey();
        }
        return res;
    }

    public static void main(String args[]){
        int[][] arr = new int[][]{{0,3},{0,3},{2,4},{5,6}};
        char[] chars = new char[]{'A','B','C','D'};

        System.out.println(merge(arr,chars));
    }
}
