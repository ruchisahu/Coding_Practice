#include "EmailAccountsVectorBased.h"
#include <algorithm>
#include <map>
#include <iterator>

vector<vector<string>> EmailAccountsVectorBased::AccountsMerge(vector<vector<string>>& accounts)
{

	vector<int> clusterRoot;
	for (int i = 0; i < accounts.size(); i++)
	{
		clusterRoot.push_back(i);
	}

	map<string, int> emailCluster;
	

	//find the duplicate emails and update the clusterMembership
	for (int i = 0; i < accounts.size(); i++)
	{
		for (int j = 1; j < accounts[i].size(); j++)
		{
			auto emailKV = emailCluster.find(accounts[i][j]);
			if (emailKV == emailCluster.end())
			{
				emailCluster.insert(make_pair(accounts[i][j], clusterRoot[i]));
			}
			else
			{
				auto minClusterId = min(emailKV->second, clusterRoot[i]);
				emailCluster[accounts[i][j]] == Join(clusterRoot, emailKV->second,minClusterId);

				//clusterRoot[i] = minClusterId;
			}
		}
	}

	//Flatten clusterMembership 
	for (int i = 0; i < clusterRoot.size(); i++)
	{
		SetClusterMin(clusterRoot,i);
	}

	//Prepare for return value
	for (int i = 0; i < accounts.size(); i++)
	{
		accounts[i].erase(accounts[i].begin() + 1, accounts[i].end());
	}

	//EnsureEmailConvergence
	for (auto emailClusterItr = emailCluster.begin(); emailClusterItr != emailCluster.end(); emailClusterItr++)
	{
		emailCluster[emailClusterItr->first] = clusterRoot[emailClusterItr->second];
		accounts[clusterRoot[emailClusterItr->second]].push_back(emailClusterItr->first);
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

int EmailAccountsVectorBased::SetClusterMin(vector<int>& clusterRoot, int index)
{
	if (clusterRoot[index] == index)
		return index;

	clusterRoot[index] = SetClusterMin(clusterRoot, clusterRoot[index]);
	return clusterRoot[index];
}

int EmailAccountsVectorBased::Join(vector<int>& clusterRoot, int index, int currentMin)
{
	currentMin = min(currentMin, clusterRoot[index]);
	
	if (clusterRoot[index] == index) 
	{
		clusterRoot[index] = currentMin;
	}
	else
	{
		clusterRoot[index] = Join(clusterRoot, clusterRoot[index], currentMin);
	}	
	return clusterRoot[index];
}


