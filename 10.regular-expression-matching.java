/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
//https://leetcode.cn/problems/regular-expression-matching/solutions/2361807/10-zheng-ze-biao-da-shi-pi-pei-dong-tai-m5z1i/
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 2; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 1; j < p.length() + 1; j++){
                if(p.charAt(j-1) == '*'){
                    if(dp[i][j - 2]){
                        dp[i][j] = true;
                    }
                    //dp[i - 1][j] means "*" repeats, it judges before it repeats, whether it match
                    else if(s.charAt(i - 1) == p.charAt(j - 2) && dp[i - 1][j]){
                        dp[i][j] = true;
                    }
                        
                    else if(p.charAt(j - 2) == '.' && dp[i-1][j]){
                        dp[i][j] = true;
                    }
                }
                else{
                    if(p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
// @lc code=end

