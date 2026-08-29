class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        if(n<2){
            return nums;
        }
        int[] output = new int[n];
        int[] preMul = new int[n];
        int[] postMul = new int[n];
        preMul[0]=1;
        postMul[n-1]=1;
        for(int i=1;i<n;i++){
            preMul[i]=preMul[i-1]*nums[i-1];
            postMul[n-1-i]=postMul[n-i]*nums[n-i];
        }
        for(int i=0;i<=n-1;i++){
            output[i]=preMul[i]*postMul[i];
        }
        return output;
    }
}  
