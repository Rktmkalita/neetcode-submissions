class Solution {
    private int maxCount = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1)
                    dfs(grid, i, j, new int[1]);
            }
        }
        return maxCount;
    }

    private void dfs(int[][] grid, int i, int j, int[] count){
        if(i<0 || i>=grid.length
            || j<0 || j>=grid[0].length
            || grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        count[0]+=1;
        maxCount = Math.max(count[0], maxCount);
        dfs(grid, i-1, j, count);
        dfs(grid, i+1, j, count);
        dfs(grid, i, j-1, count);
        dfs(grid, i, j+1, count);
    }
}
