class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Map<Integer, Integer> map = new HashMap<>();
            map.put(nums[i],i);
            for(int j=i+1;j<n;j++){
                int sum = nums[i]+nums[j];
                if(map.containsKey(-sum)){
                    if(map.get(-sum)!=i && map.get(-sum)!=j){
                        List<Integer> list = new ArrayList<>(List.of(nums[i],nums[j],-sum));
                        Collections.sort(list);
                        set.add(list);
                    }
                }
                map.put(nums[j],j);
            }
        }
        return List.copyOf(set);
    }
}
