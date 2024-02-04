class Solution {
    public int stoneGameII(int[] piles) {
        int N = piles.length;
        int[] sum = new int[N];
        int[][] memo = new int[N][N];
        sum[N - 1] = piles[N-1];
        for (int i = N - 2; i >= 0; i--) {
            sum[i] = sum[i + 1] + piles[i];
        }
        return dfs(0, 1, sum, memo);
    }
    public int dfs(int index, int M, int[] sum, int[][] memo){
        if(index == sum.length){
            return 0;
        }
        if(sum.length - index <= M * 2){
            return sum[index];
        }
        if(memo[index][M] != 0){
            return memo[index][M];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= M * 2; i++){
            min = Math.min(min, dfs(index + i, Math.max(i, M), sum, memo));
        }
        return memo[index][M] = sum[index] - min;
    }
}