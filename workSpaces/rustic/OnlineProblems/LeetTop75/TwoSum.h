#pragma once

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
class TwoSum
{
public:

    //: returned numbers instead of index
    //: then returned the new sorted index rather than the original
    vector<int> twoSum(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector <int> ret;

        for (int i = 0; i < nums.size(); i++)
        {
            int search = target - nums[i];
            int res = binary_search(nums, search);
            if (res != -1)
            {
                ret = { i,res };
                break;
            }
        }
        return ret;
    }

    int binary_search(vector<int> nums, int value)
    {
        int lo = 0, hi = nums.size() - 1, mid;
        int res = -1;

        while (lo <= hi)
        {
            mid = lo + (hi - lo) / 2;
            if (value < nums[mid])
                hi = mid - 1;
            else if (value > nums[mid])
                lo = mid + 1;
            else if (value == nums[mid])
            {
                res = mid; break;
            }
        }

        return res;
    }

    struct node { int value; int index; };

    vector<int> twoSum2(vector<int>& nums, int target) {

        vector<int> indices(1000,-1);
        for (int i = 0; i < nums.size(); i++)
        {
            indices[nums[i]] = i;
        }

        for (int i = 0; i < indices.size(); i++)
        {
            if (indices[i] == -1)
                continue;
            if (indices[target - i] == -1)
                continue;
            return vector<int>{indices[i], indices[target - i]};
        }
    }

    struct indexNode {
        
        vector<int> locs = { -1 };
    };

    vector<int> twoSum3(vector<int>& nums, int target) {

        vector<indexNode> indices(1000);
        for (int i = 0; i < nums.size(); i++)
        {
            indices[nums[i]].locs.push_back(i);
        }
        int i = 0;
        
        for (; i < indices.size(); i++)
        {
            if (indices[i].locs[0] == -1)
                continue;
            if (indices[target - i].locs[0] == -1)
                continue;
            break;
        }

        if(i == (target-i))
            return vector<int>{indices[i].locs[0], indices[i].locs[1]};
        else
            return vector<int>{indices[i].locs[0], indices[target - i].locs[0]};
        
    }
};

