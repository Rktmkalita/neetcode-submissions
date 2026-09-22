class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(candidates);
        backtrack(res, candidates, target, 0, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(Set<List<Integer>> res, int[] candidates, int target, int sum, int i, List<Integer> subset){
        if(i>=candidates.length || sum>=target){
            if(sum==target)
                res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(candidates[i]);
        backtrack(res, candidates, target, sum+candidates[i], i+1, subset);
        subset.remove(subset.size()-1);
        int j = i+1;
        while(j<candidates.length && candidates[j]==candidates[i]){
            j++;
        }
        backtrack(res, candidates, target, sum, j, subset);
    }
}
