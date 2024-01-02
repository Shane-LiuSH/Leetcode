/*
 * @lc app=leetcode id=51 lang=java
 *
 * [51] N-Queens
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
        
    }
    private void dfs(char [][] board, int column, List<List<String>> res){
        if(column == board.length){
            res.add(constructor(board));
        }
        for(int i = 0; i < board.length; i++){
            if(validate(board, i, column)){
                board[i][column] = 'Q';
                dfs(board, column + 1, res);
                board[i][column] = '.';
            }
        }
    }

    private boolean validate(char [][] board, int x, int y){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == 'Q'&& (x == i || y == j || x + y == i + j || x + j == i + y)){
                    return false;
                }
            }
        }
        return true;
    }
    private List<String> constructor(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            res.add(new String(board[i]));
        }
        return res;
    }
}
// @lc code=end

