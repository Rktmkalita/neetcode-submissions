class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums,res,0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, int i, List<Integer> subset){
        if(i>=nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums,res,i+1,subset);
        subset.remove(Integer.valueOf(nums[i]));
        backtrack(nums,res,i+1,subset);
    }
}
