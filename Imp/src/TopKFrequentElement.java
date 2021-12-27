import java.util.*;

public class TopKFrequentElement {
    public static List<Integer> topK(int[] nums,int k){
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i,1)+1);
        }
        /*
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(map.get(o1) == map.get(o2)){
                    return o2 - o1;
                }
                return map.get(o2) - map.get(o1);
            }
        });
        */
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b) ->
                map.get(a) == map.get(b) ? b - a : map.get(b) - map.get(a));

        pq.addAll(map.keySet());
        for(int i = 0; i < k; i++){
            res.add(pq.poll());
        }

        return res;
    }

    public static void main(String args[]){
        int[] list = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        System.out.println(topK(list,4));
    }


}
