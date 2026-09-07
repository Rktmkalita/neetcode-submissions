class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l=0, r=m*n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            System.out.println(matrix[mid/n][mid%n]);
            if(matrix[mid/n][mid%n]==target){
                return true;
            }else if(matrix[mid/n][mid%n]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return false;
    }
}
