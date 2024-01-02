/*
 * @lc app=leetcode id=37 lang=java
 *
 * [37] Sudoku Solver
 */

// @lc code=start
class Solution {
    public void solveSudoku(char[][] board) {
        isSolved(board);
    }

    public boolean isSolved(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c) == true){
                            board[i][j] = c;
                            if(isSolved(board) == true){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    //if there is no num match the answer, return false
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int i, int j, char c){
        for(int row = 0; row < 9; row++){
            if(board[row][j] == c){
                return false;
            }
        }
        for(int column = 0; column < 9; column++){
            if(board[i][column] == c){
                return false;
            }
        }
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
            for(int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++){
                if(board[row][column] == c)
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

