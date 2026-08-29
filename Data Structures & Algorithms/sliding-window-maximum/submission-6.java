class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int result[] = new int[n-k+1];
        int preMax[] = new int[n];
        int postMax[] = new int[n];
        preMax[0] = nums[0];
        postMax[n-1] = nums[n-1];
        for(int i=1;i<n;i++){
            if(i%k==0)
                preMax[i]=nums[i];
            else{
                preMax[i] = Math.max(nums[i],preMax[i-1]);
            }

            if((n-1-i)%k==0){
                postMax[n-1-i]=nums[n-1-i];
            }else{
                postMax[n-1-i] = Math.max(nums[n-1-i],postMax[n-i]);
            }
        }

        for(int i=0;i<n-k+1;i++){
            result[i] = Math.max(preMax[i+k-1],postMax[i]);
        }
        return result;
    }

}
