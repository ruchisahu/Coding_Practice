#pragma once

#include <vector>
#include <map>
#include <string>

using namespace std;
class EmailAccountMerge
{
public:
	vector<vector<string>> AccountsMerge(vector<vector<string>>& accounts);
	int clusterMin(map<int, int>& clusterRoot, int currentCluster);
};

