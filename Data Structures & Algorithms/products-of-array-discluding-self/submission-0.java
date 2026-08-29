class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n<2){
            return nums;
        }
        int[] output = new int[n];
        int[] preMul = new int[n];
        int[] postMul = new int[n];
        preMul[0]=nums[0];
        postMul[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            preMul[i]=preMul[i-1]*nums[i];
            postMul[n-1-i]=postMul[n-i]*nums[n-1-i];
        }
        for(int i=1;i<n-1;i++){
            output[i]=preMul[i-1]*postMul[i+1];
        }
        output[0]=postMul[1];
        output[n-1]=preMul[n-2];
        return output;
    }
}  
