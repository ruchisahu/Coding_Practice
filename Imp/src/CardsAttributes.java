import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardsAttributes {
    public static boolean cards(int k,int[][] attributes){
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        int[] card1 = attributes[0];
        int[] card2 = attributes[1];
        int[] card3 = attributes[2];
        int len = card1.length;

        int index = 0;
        while(index < len){
            List<Integer> list = new ArrayList<>();
            if(card1[index] != card2[index]){
                for(int i = 0; i < len;i++) {
                    if (card1[index] != i && card2[index] != i) {
                        list.add(i);
                    }
                }
            }else {
                list.add(card1[index]);
            }
            map.put(index,list);
            index++;
        }

        for(int i = 0; i < len;i++){
            List<Integer> list = new ArrayList<>();
            list = map.get(i);
            if(!list.contains(card3[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){
        int k = 3;
        int[][] attributes = new int[][]{{2, 0, 1, 2},{1, 1, 0, 1},{0, 1, 2, 0}};
        System.out.println(cards(k,attributes));
    }
}
