import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
public class removeStones {
	static Map<Integer, Integer> f = new HashMap<>();
    static int islands = 0;

    public static int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public static int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }


	public static void main(String[] args) {
		int[][] stones= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
				System.out.println(removeStones(stones));

	}

}
