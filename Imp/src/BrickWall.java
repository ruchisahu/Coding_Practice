import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        if(wall == null) return 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(List<Integer> list : wall){
            int len = 0;
            for(int i = 0; i < list.size()-1; i++){
                len += list.get(i);
                map.put(len,map.getOrDefault(len,0)+1);
                count = Math.max(count,map.get(len));
            }
        }
        System.out.println("wall" + wall.size());
        System.out.println("count" + count);

        return wall.size() - count;
    }

    public static void main(String args[]){
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(2);
        list1.add(1);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(1);
        list2.add(2);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(3);
        list3.add(2);

        List<Integer> list4 = new ArrayList<>();
        list4.add(2);
        list4.add(4);

        List<Integer> list5 = new ArrayList<>();
        list5.add(3);
        list5.add(1);
        list5.add(2);

        List<Integer> list6 = new ArrayList<>();
        list6.add(1);
        list6.add(3);
        list6.add(1);
        list6.add(1);

        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        res.add(list3);
        res.add(list4);
        res.add(list5);
        res.add(list6);

        System.out.println(leastBricks(res));

    }


}
