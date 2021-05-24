import java.util.*;

public class KnightPhonePath {
	
	
	
	
	static int knightmove(int start, int move, int[][] map,String str) {
		if(str==null) str=str+"->"+start;
		if(move==0) {
			System.out.println("move:"+str);
			return 1;
		}
		int count=0;
		for(int neigh: map[start]) {
			
			count+=knightmove(neigh,move-1,map,str+"->"+neigh);
			
		}
		return count;
		
	}

	public static void main(String[] args) {
		 int[][] map = new int[][]{{4,6},
            {6,8},
            {7,9},
            {4,8},
            {3,9,0},
            {},
            {7,1,0},
            {6,2},
            {3,1},
            {2,4}}; 
		int start=4;
		int move=2;
		System.out.println(knightmove(start,move,map,""+start));


	}

}
