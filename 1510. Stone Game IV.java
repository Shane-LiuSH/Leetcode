class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] memo = new Boolean[n + 1];
        return dfs(memo, n);

    }

    public boolean dfs(Boolean[] memo, int n) {
        if (memo[n] != null) {
            return memo[n];
        }
        for (int i = (int) Math.sqrt(n); i > 0; i--) {
            if (!dfs(memo, n - (i * i))) {
                return memo[n] = true;
            }
        }
        return false;
    }
}