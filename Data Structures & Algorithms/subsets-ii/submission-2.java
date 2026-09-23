class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int i, List<Integer> subset){
        if(i==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(res, nums, i+1, subset);
        subset.remove(subset.size()-1);
        int next = i+1;
        while(next<nums.length && nums[i]==nums[next]){
            next++;
        }
        backtrack(res, nums, next, subset);
    }
}
