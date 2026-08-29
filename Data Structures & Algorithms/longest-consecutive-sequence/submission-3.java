class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int maxLen = 1;
        Arrays.sort(nums);
        int len=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) continue;
            if(nums[i]+1==nums[i+1]){
                len++;
            }else{
                len=1;
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
}
