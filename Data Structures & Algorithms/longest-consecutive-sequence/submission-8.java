class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int maxLength = 0;
        for(int n : nums){
            if(!set.contains(n-1)){
                int len = 1;
                while(set.contains(n + len)){
                    len++;
                }
                maxLength = Math.max(maxLength,len);
                if(maxLength==nums.length){
                    break;
                }
            }
        }
        return maxLength;
    }
}
