class Solution {
    public int minFallingPathSum(int[][] grid) {
        for (int i = grid.length - 2; i >= 0; i--) {
            for (int j = 0; j < grid.length; j++) {
                int min = Integer.MAX_VALUE;
                for(int x = 0 ; x < grid.length; x++){
                    if(x == j){
                        continue;
                    }
                    min = Math.min(min, grid[i+1][x]);
                }
                grid[i][j] += min;
            }
        }
        return Arrays.stream(grid[0]).min().getAsInt();
    }
}