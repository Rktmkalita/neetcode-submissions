class Solution {
    public int trap(int[] height) {
        int l=0, r=height.length-1;
        int maxVal = 0;
        int prevH = 0;
        while(l<r){
            int minHeight = Math.min(height[l],height[r]);
            int sum = 0;
            for(int i=l+1;i<r;i++){
                if(height[i]<minHeight){
                    sum+=minHeight-height[i]-Math.max(prevH-height[i],0);
                }
            }
            maxVal+=sum;
            prevH = minHeight;
            while(l<r && height[l]<=minHeight){
                l++;
            }
            while(l<r && height[r]<=minHeight){
                r--;
            }
        }
        return maxVal;
    }
}
