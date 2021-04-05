
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
#pragma once
#include <vector>
class BestTimeToBuyAndSellStock
{
public:
	int maxProfit(std::vector<int>& prices);

    int maxProfit02(std::vector<int>& prices) {

        int maxprofit = 0, minprice = prices[0];

        for (int i = 0; i < prices.size(); i++)
        {
            if (minprice > prices[i])
                minprice = prices[i];
            else if (maxprofit < prices[i] - minprice)
                maxprofit = prices[i] - minprice;
        }

        return maxprofit;
    }

    //:Test fail .. forgot to keep minimum from the left, see://forgot
    int maxProfit03(std::vector<int>& prices)
    {

        int mp = 0, msi = 0;
        //choose best stock price if you sell today , go through all the items and keep the best stock/profit
        for (int i = 1; i < prices.size(); i++)
        {
            
            //:forgot
            if (prices[msi] > prices[i])
            {
                msi = i;
            }
            else
            {
                int cmp = prices[i] - prices[msi];
                if (cmp > mp)
                    mp = cmp;
            }

        }

        return mp;

    }
};

