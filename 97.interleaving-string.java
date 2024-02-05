/*
 * @lc app=leetcode id=97 lang=java
 *
 * [97] Interleaving String
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp =new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        for(int i = 1; i <=s1.length(); i++){
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i-1) && dp[i-1][0];
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = s2.charAt(i - 1) == s3.charAt(i - 1) && dp[0][i-1];
        }
        for(int i = 1; i <=s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                dp[i][j] = (s1.charAt(i-1) == s3.charAt(i + j - 1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(
                        i + j - 1) && dp[i][j-1]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
// @lc code=end
