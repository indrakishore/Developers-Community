/* Problem Statement : A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
Given a list of stones positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.
Example 1:

Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
*/

/* Approach : The approach uses dynamic programming and recursion with memoization to determine if the frog can cross the river. Starting from the first stone, the frog attempts jumps of size `k-1`, `k`, or `k+1` from its current position, where `k` is the size of the last jump. A recursive function checks if the frog can reach the last stone by trying all possible valid jumps. The results of previously computed states (current stone, last jump) are stored in a DP table (`t`), and a map (`mp`) is used to track the stone positions for efficient lookup. This avoids redundant calculations and ensures an optimal solution.*/

class Solution {
public:
    int n;
    unordered_map<int, int> mp;
    int t[2001][2001];

    bool solve(vector<int>& stones,int csi,int pj)
    {
        if(csi==n-1){
            return true;
        }
        bool res=false;

        if(t[csi][pj]!=-1)
        {
            return t[csi][pj];
        }
        
        for(int nj=pj-1;nj<=pj+1;nj++)
        {
            if(nj>0)
            {
                int next_s=stones[csi]+nj;

                if(mp.find(next_s)!=mp.end())
                {
                    res=res||solve(stones,mp[next_s],nj);
                }
            }
        }
        return t[csi][pj]=res;
    }
    bool canCross(vector<int>& stones) {
        n=stones.size();
        if(stones[1]!=1)
        {
            return false;
        }
        for(int i=0;i<n;i++)
        {
            mp[stones[i]]=i;
        }

        memset(t,-1,sizeof(t));
        return solve(stones,0,0);
    }
};
