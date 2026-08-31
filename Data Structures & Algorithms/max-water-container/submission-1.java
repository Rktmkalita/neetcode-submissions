class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length-1;
        int maxAr = 0;
        while(l<r){
            int minHeight = Math.min(heights[l],heights[r]);
            int area = minHeight * (r-l);
            maxAr = Math.max(area,maxAr);
            while(l<r && heights[l]<=minHeight){
                l++;
            }
            while(l<r && heights[r]<=minHeight){
                r--;
            }
        }
        return maxAr;
    }
}
