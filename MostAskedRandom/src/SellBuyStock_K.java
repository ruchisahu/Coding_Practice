
public class SellBuyStock_K 
{
	public static int maxProfit(int k, int[] prices) {
    int len = prices.length;
    if (k >= len / 2) return quickSolve(prices);
    
    int[][] t = new int[k + 1][len];
    for (int i = 1; i <= k; i++) {
        int tmpMax =  -prices[0];
        for (int j = 1; j < len; j++) {
            t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
            tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            System.out.println("t[i][j]  :"+t[i][j] + "Max:   "+tmpMax);
        }
    }
    return t[k][len - 1];
}


private static int quickSolve(int[] prices) {
    int len = prices.length, profit = 0;
    for (int i = 1; i < len; i++)
        // as long as there is a price gap, we gain a profit.
        if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
    return profit;
}

	public static void main(String[] args) {
		int k = 2;
		int[] prices = {3,2,6,5,0,3};
		System.out.println(maxProfit(k,prices));

	}

}
