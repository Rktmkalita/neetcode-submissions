class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, new ArrayList<>(), new HashSet<>());
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, List<Integer> subset, Set<Integer> set){
        if(subset.size()==nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i])){
                subset.add(nums[i]);
                set.add(nums[i]);
                backtrack(res, nums, subset, set);
                subset.remove(subset.size()-1);
                set.remove(nums[i]);
            }
        }
    }
}
