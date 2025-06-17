/*
Approach (Backtracking):
Start DFS with a pivot index to avoid revisiting previous elements
Begin from index 0 and explore all candidates recursively to find combinations summing to the target.

Use a path vector to track the current combination:
Add a candidate to path, subtract from target, and recursively call with the same index (allowing repeated elements).
Backtrack:
When a combination doesn't work or reaches the target, remove the last element (undo the choice) to try the next one.

Time Complexity: O(2^T)
T = target
In the worst case (like candidates = [1]), we try every possibility up to target.
It’s exponential because each number can be picked multiple times.
In more precise terms:
Let N be number of candidates and T be the target.
Time = O(N^(T/minCandidateValue))

Space Complexity: O(T)
Recursion depth can go up to T in the worst case.
path size also at most T in that scenario.
Result storage not counted in SC unless explicitly mentioned.
*/


class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> path;
        helper(candidates,target,0,result,path);
        return result;
    }
    void helper(vector<int>& candidates, int target, int pivot,
    vector<vector<int>> &result, vector<int> &path){
        // base
        if(target == 0){
            result.emplace_back(path);
            return;
        }
        if(target < 0) return;
        // logic
        for(int i = pivot; i<candidates.size();++i){
            path.emplace_back(candidates[i]);
            helper(candidates,target-candidates[i],i,result,path);
            path.pop_back();
        }

    }
};
