class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int target = -nums[i];
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i+1;j<nums.length;j++){
                int diff = target-nums[j];
                if(map.containsKey(diff)){
                    List<Integer> listOf3 = new ArrayList<>();
                    listOf3.add(nums[i]);
                    listOf3.add(diff);
                    listOf3.add(nums[j]);
                    result.add(listOf3);
                    while (j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
                }
                map.put(nums[j],j);
            }
        }
        return result;
    }
}
