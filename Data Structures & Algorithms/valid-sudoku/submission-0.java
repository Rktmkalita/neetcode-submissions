class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> numbersA = new HashSet<>();
        Set<Character> numbersB = new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    if(numbersA.contains(board[i][j])){
                        return false;
                    }else{
                        numbersA.add(board[i][j]);
                    }
                }
                if(board[j][i]!='.'){
                    if(numbersB.contains(board[j][i])){
                        return false;
                    }else{
                        numbersB.add(board[j][i]);
                    }
                }
            }
            numbersA.clear();
            numbersB.clear();
        }
        numbersB.clear();
        for(int i=0;i<9;i++){
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    int row = (i / 3) * 3 + j;
                    int col = (i % 3) * 3 + k;
                    // System.out.print(board[row][col]+" ");
                    if(board[row][col]!='.'){
                        if(numbersB.contains(board[row][col])){
                            return false;
                        }else{
                            numbersB.add(board[row][col]);
                        }
                    }
                }
            }
            numbersB.clear();
        }
        return true;
    }
}
