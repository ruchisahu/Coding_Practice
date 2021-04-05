#pragma once
#include <vector>
#include <string>
using namespace std;
class EmailAccountsVectorBased
{

public:
	vector<vector<string>> AccountsMerge(vector<vector<string>>& accounts);
	int SetClusterMin(vector<int>& clusterRoot, int index);
	int Join(vector<int>& clusterRoot, int index, int currentMin);
};

