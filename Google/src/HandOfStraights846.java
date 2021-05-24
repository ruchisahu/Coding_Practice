import java.util.PriorityQueue;

public class HandOfStraights846 {
	public static boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:hand) pq.add(num);
        while(!pq.isEmpty()){
            int smallest = pq.peek();
            for(int i = 0;i<W;i++){
                if(!pq.contains(smallest + i)) return false;
                else pq.remove(smallest +i);
            }
        }
        return true;
    }
	public static void main(String args[]){
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int w = 3;

        //System.out.println(isNStraightHand(hand,w));
        //List<List<Integer>> ans =
        System.out.println(isNStraightHand(hand,w));
    }
}