// LeetTop75.cpp : This file contains the 'main' function. Program execution begins and ends there.
//


#include "CourseSchedule.h"
#include <iostream>
#include <vector>
#include "BestTimeToBuyAndSellStock.h"
#include "LongestCommonSubsequence.h"
#include "TwoSum.h"

using namespace std;
int main()
{

    LongestCommonSubsequence lcs;
    auto lcsRes1 = lcs.longestCommonSubsequence("abc", "abcde");
    auto lcsRes2 = lcs.longestCommonSubsequence("abcd", "abcabcde");
    auto lcsRes3 = lcs.longestCommonSubsequence("1abc2abcd3abcde", "abcde");
    vector<vector<int>> depCycle =
    {
        {1,0},
        {0,1}
    };

    vector<vector<int>> depNoCycle =
    {
        {1,0}
   };
    //4
    //[[2, 0], [1, 0], [3, 1], [3, 2], [1, 3]]
    vector<vector<int>> depCycle02 =
    {
        {2,0},
        {1,0},
        {3,1},
        {3,2},
        {1,3}
    };
    CourseSchedule coursesched;
    auto courseRes = coursesched.canFinish(2, depCycle);
    auto courseRes2 = coursesched.canFinish(2, depNoCycle);
    auto courseRes3 = coursesched.canFinish(4, depCycle02);

    vector <int> tstest = { 2,7,11,15 };
    vector <int> tstest2 = { 3,2,4 };
    TwoSum ts;
    auto res = ts.twoSum2(tstest2, 6);

    BestTimeToBuyAndSellStock btbss;

    vector <int> leetCode = { 7,1,5,3,6,4 };
    btbss.maxProfit(leetCode);
    
}

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
