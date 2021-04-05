#include "EmailAccountMerge.h"

vector<vector<string>> EmailAccountMerge::AccountsMerge(vector<vector<string>>& accounts)
{
    map<string, int> emailToCluster;
    //map<int, vector<string>> clusterToAllEmails;
    map<int, string> clusterName;
    map<int, int> clusterRoot;

    for (int i = 0; i < accounts.size(); i++)
    {
        clusterName.insert((make_pair(i, accounts[i][0])));
        clusterRoot[i] = i;
    }

    for (int i = 0; i < accounts.size(); i++)
    {
        //:bugbug did i++ instead of j++
        for (int j = 1; j < accounts[i].size(); j++)
        {
            //:bugbug used accounts[i][1] instead of [i][j]
            auto email = emailToCluster.find(accounts[i][j]);
            if (email != emailToCluster.end()) //found in hash
            {
                //change cluster belonginess to smaller one 
                //(union clusetera, clusterb)

                auto minId = min(email->second, clusterRoot[i]);
                //:bugbug used == instead of = 
                clusterRoot[i] = minId;
                emailToCluster[accounts[i][j]] = minId;
            }
            else //not found
            {
                emailToCluster.insert(make_pair(accounts[i][j], i));
            }
        }
    }

    for (int i = 0; i < accounts.size(); i++)
    {
        //:bugbug needed to pass i , i had passed clusterRoot[i]
        clusterMin(clusterRoot, i);
    }

    
    
    //for each cluster group create vector list
    //for each cluster 
    // get subcluster and emails 
    /// create them in vector.

    

    return vector<vector<string>>();
}



int EmailAccountMerge::clusterMin(map<int, int>& clusterRoot, int currentCluster)
{
    if (clusterRoot[currentCluster] == currentCluster)
        return currentCluster;

    clusterRoot[currentCluster] = clusterMin(clusterRoot, min(currentCluster, clusterRoot[currentCluster]));
}


