class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
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
                }
                map.put(nums[j],j);
            }
        }
        return new ArrayList<>(result);
    }
}
