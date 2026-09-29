class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(i,j,word,0,board, new int[board.length][board[0].length])){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, String word, int pos, char[][] board, int[][] visited){
        if(i>=board.length || i<0 || j>=board[0].length 
            || j<0 || visited[i][j]==1 || board[i][j] != word.charAt(pos)){
            return false;
        }
        
        if (pos == word.length() - 1) {
            return true;
        }

        visited[i][j] = 1;
        if(dfs(i+1, j, word, pos+1, board, visited) 
                || dfs(i-1, j, word, pos+1, board, visited)
                || dfs(i, j+1, word, pos+1, board, visited)
                || dfs(i, j-1, word, pos+1, board, visited)){
            return true;
        }
        visited[i][j] = 0;
        return false;
    }
}
