class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2) return 0;
        int[] preMax = new int[n];
        int[] postMax = new int[n];
        preMax[0]=0;
        postMax[0]=0;
        for(int i=1;i<n;i++){
            preMax[i]=Math.max(height[i-1],preMax[i-1]);
            postMax[n-1-i]=Math.max(height[n-i],postMax[n-i]);
        }
        int totalWater = 0;
        for(int i=0;i<n;i++){
            totalWater+=Math.max(Math.min(postMax[i],preMax[i])-height[i],0);
        }
        return totalWater;
    }
}
