class Solution {
    public int maxArea(int[] heights) {
        int left=0, right=heights.length-1;
        int maxArea = 0;
        while(left<right){
            int currHeight = Math.min(heights[left],heights[right]);
            int width = right-left;
            int area = currHeight*width;
            if(maxArea<area){
                maxArea = area;
            }
            while(left<right && heights[left]<=currHeight) left++;
            while(left<right && heights[right]<=currHeight) right--;
        }
        return maxArea;
    }
}
