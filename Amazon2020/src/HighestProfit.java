import java.util.*;

//https://leetcode.com/discuss/interview-question/868302/Amazon-or-OA2-2020-or-Find-The-Highest-Profit
public class HighestProfit {
	public static long highestProfit(int numSuppliers, List<Long> inventory, long order) {
	    long max = 0;
	    HashMap<Long, Integer> map = new HashMap<>(); // inventory->count
	    for(Long i : inventory) {
	        if (i > 0) {
	            map.put(i, map.getOrDefault(i, 0) + 1);
	            max = Math.max(i, max);
	        }
	    }

	    long profit = 0;
	    while(max > 0 && order > 0) {
	        int count = map.get(max);
	        long multiplier = order - count < 0 ? order : count;

	        profit += multiplier * max;
	        order -= multiplier;

	        map.remove(max);
	        max--;
	        map.put(max, map.getOrDefault(max, 0) + count);
	    }

	    return profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
