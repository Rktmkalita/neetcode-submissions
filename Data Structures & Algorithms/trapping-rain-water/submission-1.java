class Solution {
    public int trap(int[] height) {
        int n=height.length;
        if(n<=2) return 0;
        int totalWater = 0;
        int leftMax = height[0], rightMax = height[n-1];
        int left=0, right=n-1;
        while(left<right){
            if(leftMax<rightMax){
                left++;
                leftMax = Math.max(leftMax,height[left]);
                totalWater+=leftMax-height[left];
            }else{
                right--;
                rightMax = Math.max(rightMax,height[right]);
                totalWater+=rightMax-height[right];
            }
        }
        return totalWater;
    }
}
