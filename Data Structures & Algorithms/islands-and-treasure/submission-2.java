class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dir = new int[][]{
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };
        while(!q.isEmpty()){
            int[] current = q.poll();
            for(int[] d : dir){
                int i = current[0]+d[0];
                int j = current[1]+d[1];
                if(i<0 || i>=grid.length
                    || j<0 || j>=grid[0].length
                    || grid[i][j]!=Integer.MAX_VALUE){
                    continue;
                }
                grid[i][j] = grid[current[0]][current[1]]+1;
                q.offer(new int[]{i,j});
            }
        }
    }
}
