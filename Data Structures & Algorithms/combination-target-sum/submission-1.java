class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(set, nums, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(set);
    }

    private void backtrack(Set<List<Integer>> set, int[] nums, int target, int i, List<Integer> subset, int sum){
        if(i==nums.length || sum>=target){
            if(sum==target){
                set.add(new ArrayList<>(subset));
            }
            return;
        }
        subset.add(nums[i]);
        backtrack(set, nums, target, i+1, subset, sum+nums[i]);
        backtrack(set, nums, target, i, subset, sum+nums[i]);
        subset.remove(subset.size()-1);
        backtrack(set, nums, target, i+1, subset, sum);
    }
}
