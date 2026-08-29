class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1){
            return nums;
        }
        int[] result = new int[nums.length-k+1];
        int maxValue = nums[0];
        for(int i=0;i<k;i++){
            maxValue = Math.max(maxValue,nums[i]);
        }
        result[0]=maxValue;
        for(int i=k;i<nums.length;i++){
            if(maxValue==nums[i-k]){
                // System.out.println(nums[i-k]);
                maxValue = nums[i-k+1];
                for(int j=i-k+1;j<i+1;j++){
                    maxValue=Math.max(maxValue,nums[j]);
                }
            }
            maxValue = Math.max(maxValue,nums[i]);
            result[i-k+1]=maxValue;
        }
        return result;
    }
}
