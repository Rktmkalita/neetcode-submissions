class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rows = new HashMap<>();
        Map<Integer,Set<Character>> cols = new HashMap<>();
        Map<String,Set<Character>> sqrs = new HashMap<>();
        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.') continue;
                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                    || sqrs.computeIfAbsent(r/3+","+c/3, k -> new HashSet<>()).contains(board[r][c]))
                    return false;
                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                sqrs.get(r/3+","+c/3).add(board[r][c]);
            }
        }
        return true;
    }
}
