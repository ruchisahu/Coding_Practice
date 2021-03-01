#include "BestTimeToBuyAndSellStock.h"

using namespace std;
int BestTimeToBuyAndSellStock::maxProfit(std::vector<int>& prices)
{

	vector<int> leftSmall(prices), rightBig(prices);

	//findleft small(
	int min = leftSmall[0];
	for (int i = 0; i < leftSmall.size(); i++)
	{
		if (min <= leftSmall[i])
			leftSmall[i] = min;
		else
			min = leftSmall[i];
	}

	int max = rightBig[rightBig.size()-1];
	for (int i = rightBig.size() - 1; i >= 0; i--)
	{
		if (max >= rightBig[i])
			rightBig[i] = max;
		else
			max = rightBig[i];
	}

	int mp = rightBig[0] - leftSmall[0];
	for (int i = 0; i < prices.size(); i++)
	{
		if (mp < (rightBig[i] - leftSmall[i]))
		{
			mp = rightBig[i] - leftSmall[i];
		}
	}


	return mp;
}
