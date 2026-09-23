class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void backtrack(Set<List<Integer>> res, int[] nums, int i, List<Integer> subset){
        if(i>=nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(res, nums, i+1, subset);
        subset.remove(subset.size()-1);
        int next = i+1;
        while(next<nums.length && i==next){
            next++;
        }
        backtrack(res, nums, next, subset);
    }
}
