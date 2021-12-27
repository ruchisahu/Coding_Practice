import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class HandofStraights {
    public static boolean isNStraightHand(int[] hand, int W) {
        if(hand == null || hand.length == 0) return false;
        if(hand.length % W != 0) return false;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        while(map.size() > 0){
            int key = map.firstKey();

            for(int i = 0; i < W; i++){
                if(!map.containsKey(key + i)){
                    return false;
                }

                if(map.get(key + i) == 1){
                    map.remove(key + i);
                }else{
                    map.put(key + i, map.get(key + i) - 1);
                }
            }
        }
        return true;
    }

    public static List<List<Integer>> NStraightHand(int[] hand, int W){
        List<List<Integer>> ans = new ArrayList<>();
        if(hand == null || hand.length == 0) return ans;
        if(hand.length % W != 0) return ans;

        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i : hand){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        while(map.size() > 0){
            int key = map.firstKey();
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < W; i++){
                if(!map.containsKey(key + i)){
                    return new ArrayList<>();
                }
                if(map.get(key + i) == 1){
                    map.remove(key + i);
                }else {
                    map.put(key + i, map.get(key + i) - 1);
                }
                list.add(key + i);
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String args[]){
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int w = 3;

        //System.out.println(isNStraightHand(hand,w));
        //List<List<Integer>> ans =
        System.out.println(NStraightHand(hand,w));
    }
}
