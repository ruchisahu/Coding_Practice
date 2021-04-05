#pragma once
#include <string>
#include <vector>

///
///https://leetcode.com/problems/longest-common-subsequence/
/// 
using namespace std;
class LongestCommonSubsequence
{
public:
    int longestCommonSubsequence(string text1, string text2) {

        int maxL = 0;
        if (text1.size() == 0 || text2.size() == 0)
            return 0;
        
        vector<vector<int>> matrix(text1.size(), vector<int>(text2.size(), 0));

        
        
        //:not added maxL
        if (text1[0] == text2[0])
        {
            matrix[0][0] = 1;
            maxL = 1;
        }

        //Bug: in the initial setup all teh values are set to 1 if any matches
        //:Bug , j,j should be 0 not 1
        for (int i = 1; i < text1.size(); i++)
            if (text1[i] == text2[0])
            {
                matrix[i][0] = 1;
                maxL = 1;
            }
            else
                matrix[i][0] = matrix[i - 1][0];
        for (int j = 1; j < text2.size(); j++)
            if (text1[0] == text2[j])
            {
                matrix[0][j] = 1;
                maxL = 1;
            }
            else
                matrix[0][j] = matrix[0][j - 1];
      
                
        //:Bug j loop had i in compare condition
        //:Used == instead of =
        for(int i =1;i<text1.size();i++)
            for (int j = 1; j < text2.size(); j++)
            {
                if (text1[i] == text2[j])
                    matrix[i][j] = matrix[i - 1][j - 1] + 1;
                else
                    matrix[i][j] = max(matrix[i-1][j-1],max(matrix[i - 1][j], matrix[i][j - 1]));

                maxL = max(maxL, matrix[i][j]);
            }

        return maxL;
    }
};

