class Solution {
    public int minInsertions(String s) {
        String r = new StringBuilder(s).reverse().toString();
        return s.length() - lcs(s, r);
    }

    public int lcs(String s, String r) {
        int[][] dp = new int[s.length() + 1][r.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= r.length(); j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][r.length()];
    }
}