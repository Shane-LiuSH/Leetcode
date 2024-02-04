class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int N = stoneValue.length;
        Integer[] memo = new Integer[N];
        int res = dfs(0, stoneValue, memo);
        if(res == 0){
            return "Tie";
        }
        if (res < 0) {
            return "Bob";
        }
        else{
            return "Alice";
        }
        
    }
    public int dfs(int index, int[] piles, Integer[] memo){
        if(index == piles.length){
            return 0;
        }
        if(memo[index] != null){
            return memo[index];
        }
        int res = Integer.MIN_VALUE;
        int score = 0;
        for(int i = index; i < index + 3 && i < piles.length; i++){
            score += piles[i];
            res = Math.max(res, score - dfs(1 + i, piles, memo));
        }
        return memo[index] = res;
    }
}