class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l=0, r=m-1;
        while(m>1 && l<=r){
            int mid = l+(r-l)/2;
            if(matrix[mid][0]==target){
                return true;
            }else if(matrix[mid][0]>target){
                r--;
            }else{
                l++;
            }
        }
        int row = Math.max(l-1,0);
        l=0;r=matrix[row].length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(matrix[row][mid]==target){
                return true;
            }else if(matrix[row][mid]>target){
                r--;
            }else{
                l++;
            }
        }
        return false;
    }
}
