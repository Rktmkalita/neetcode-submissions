class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        int l = 0;
        while(l<n){
            int r=l;
            int currHeight = heights[l];
            while(r<n && heights[r]>=currHeight){
                r++;
            }
            int left = l;
            while(left>=0 && heights[left]>=currHeight){
                left--;
            }
            r--;
            left++;
            int area = (r-left+1)*currHeight;
            if(maxArea<area){
                maxArea = area;
            }
            l++;
        }
        return maxArea;
    }
}
