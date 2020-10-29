//https://leetcode.com/discuss/interview-question/538068/Amazon-or-OA-2020-or-Battleship


import java.util.*;

public class BattleShip {
	public static String BattleShip1(int N, String S, String T) {
	int sink = 0;
    int hit = 0;
    Set<String> hits = new HashSet<>(Arrays.asList(T.split(" ")));
    String[] ships = S.split(",");
    for (String ship : ships) {
        Set<String> shipComponents = new HashSet<>();
        char top = ship.charAt(0);
        char left = ship.charAt(1);
        char bottom = ship.charAt(3);
        char right = ship.charAt(4);
        System.out.println("ship"+ship+"  "+top+" "+left+" "+bottom+" "+right);
        for (char i = top; i <= bottom; i++) {
            for (char j = left; j <= right; j++) {
                shipComponents.add("" + i + j);
            }
        }
        if (hits.containsAll(shipComponents)) {
            sink++;
        } else {
            for (String com : shipComponents) {
                if (hits.contains(com)) {
                    hit++;
                    break;
                }
            }
        }

    }

    return "" + sink + "," + hit;

}

public static void main(String[] args) {
   //  String ans = solution(4,"1B 2C,2D 4D","2B 2D 3D 4D 4A");
    String ans = BattleShip1(12, "1A 2A,12A 11A", "12A");
    
  //  N = 3, S = "1A 1B,2C 2C" and T = "1B"
    
    String ans1 = BattleShip1(3, "1A 1B,2C 2C", "1B");
    System.out.println(ans1);
    
    //N = 4, S = "1B 2C,2D 4D" and T = "2B 2D 3D 4D 4A"
    
    String ans2 = BattleShip1(4, "1B 2C, 2D 4D", "2B 2D 3D 4D 4A");
    System.out.println(ans2);
}

}
