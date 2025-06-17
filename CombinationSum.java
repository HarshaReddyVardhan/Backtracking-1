// Approach in 3 Sentences
// This solution uses backtracking where at each index, we decide to either skip the candidate (idx + 1) or choose it (target - candidates[idx] and stay at idx).
// If the target becomes 0, the current path is a valid combination and added to the result.
// This ensures that combinations are explored recursively, allowing reuse of elements and avoidance of duplicates.

// Time Complexity: O(2^N × T)
// At each index, you have 2 options: choose or not choose → gives O(2^N) total branching.
// For each valid path, it can take up to T time to copy the path (new ArrayList(path)), contributing to the × T factor.

// Space Complexity: O(T + N)
// T: Maximum size of path when adding up smallest numbers to reach the target.
// N: Depth from the "not choose" recursion when skipping through all candidates without picking.
// Combined, the worst-case stack + list usage is O(T + N).

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path,
        List<List<Integer>> result){
        // base case
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
        if(target < 0 || idx == candidates.length) return;
        // logic
        // not choose
        helper(candidates,target,idx+1,path,result);
        // choose
        path.add(candidates[idx]);
        helper(candidates,target-candidates[idx] ,idx,path,result);
        // backtrack
        path.remove(path.size()-1);
    }
}
