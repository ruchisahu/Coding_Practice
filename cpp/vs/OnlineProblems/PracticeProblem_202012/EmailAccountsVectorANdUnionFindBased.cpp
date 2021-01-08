#include <map>
#include "EmailAccountsVectorANdUnionFindBased.h"
#include <iterator>


//:Accepted
vector<vector<string>> EmailAccountsVectorAndUnionFindBased::AccountsMerge(vector<vector<string>>& accounts)
{
	UnionFind uf = UnionFind(accounts.size());
	map<string, int> emailId;

	for (int i = 0; i < accounts.size(); i++)
	{
		//:bugubug used i=0 instead of i =1;
		for (int j = 1; j < accounts[i].size(); j++)
		{
			auto emailKV = emailId.find(accounts[i][j]);
			if (emailKV == emailId.end())
			{
				emailId.insert(make_pair(accounts[i][j], i));
			}
			else
			{
				emailId[accounts[i][j]] = uf.Union(emailKV->second, i);
			}
		}
	}

	for (int i = 0; i < accounts.size(); i++)
	{
		accounts[i].erase(accounts[i].begin() + 1, accounts[i].end());
	}

	for (auto emailIdItr = emailId.begin(); emailIdItr != emailId.end(); emailIdItr++)
	{
		auto eid = uf.Find(emailIdItr->second);
		emailId[emailIdItr->first] = eid;
		accounts[eid].push_back(emailIdItr->first);
	}

	vector<vector<string>> accountsResult;
	//removeEmptySets and copy to return 
	for (int i = 0; i < accounts.size(); i++)
	{
		if (accounts[i].size() == 1)
			continue;

		vector<string> emailVector;
		copy(accounts[i].begin(), accounts[i].end(), back_inserter(emailVector));

		accountsResult.push_back(emailVector);
	}
	return accountsResult;
}
