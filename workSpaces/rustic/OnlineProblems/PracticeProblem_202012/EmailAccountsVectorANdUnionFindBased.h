#pragma once

#include <vector>
#include <string>
using namespace std;
class EmailAccountsVectorAndUnionFindBased
{
public:
	vector<vector<string>> AccountsMerge(vector<vector<string>>& accounts);

	class UnionFind
	{
		vector<int> id;
	public:
		UnionFind(int N)
		{
			for (int i = 0; i < N; i++)
			{
				//each cluster belogs to itself 
				id.push_back(i);
			}
		}
		int Find(int p)
		{
			//:bugbug used = instead of !=
			while (id[p] != p)
				p = id[p];
			return p;
		}
		int Union(int p, int q)
		{
			auto i = Find(p);
			auto j = Find(q);

			if (i == j)
				return i;

			id[j] = i;

			return i;

		}
	};
};

