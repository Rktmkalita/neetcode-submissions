class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        int j=0;
        for(int i=1;i<n;i++){
            left[i]=nums[i-1]*left[i-1];
        }
        for(int i=n-2;i>=0;i--){
            right[i]=nums[i+1]*right[i+1];
        }
        for(int i=0;i<n;i++){
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}  
