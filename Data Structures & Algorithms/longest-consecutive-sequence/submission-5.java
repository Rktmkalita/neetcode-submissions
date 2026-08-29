class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n<2) return n;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int maxLen = 0;
        for(int num:nums){
            if(!set.contains(num-1)){
                int len = 1;
                while(set.contains(num+len)){
                    len++;
                }
                maxLen = Math.max(len,maxLen);
            }
        }
        return maxLen;
    }
}
