class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshFruits = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                } else if(grid[i][j]==1){
                    freshFruits++;
                }
            }
        }

        int count = 0;

        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean rottened = false;
            for (int k = 0; k < size; k++) {
                int[] current = q.poll();
                for (int[] d : dir) {
                    int i = current[0] + d[0];
                    int j = current[1] + d[1];
                    if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                        || grid[i][j] != 1) {
                        continue;
                    }
                    rottened = true;
                    grid[i][j] = 2;
                    freshFruits--;
                    q.offer(new int[] {i, j});
                }
            }
            if (rottened) {
                count++;
            }
        }

        return freshFruits==0 ? count : -1;
    }
}
