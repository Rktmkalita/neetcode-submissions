class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int i = 0;
        while(i<n){
            int r=i;
            int currHeight = heights[i];
            while(r<n && heights[r]>=currHeight){
                r++;
            }
            int l = i;
            while(l>=0 && heights[l]>=currHeight){
                l--;
            }
            r--;
            l++;
            int area = (r-l+1)*currHeight;
            if(maxArea<area){
                maxArea = area;
            }
            i++;
        }
        return maxArea;
    }
}
