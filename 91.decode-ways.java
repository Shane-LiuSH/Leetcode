/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            int two = Integer.valueOf(s.substring(i - 2, i));
            int one = Integer.valueOf(s.substring(i - 1, i));
            if(10 <= two && two <= 26){
                dp[i] += dp[i-2];
            }
            if(one != 0){
                dp[i] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
// @lc code=end

