import java.util.Arrays;

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                int min = matrix[i + 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(matrix[i + 1][j - 1], min);
                }
                if (j + 1 < matrix.length) {
                    min = Math.min(matrix[i + 1][j + 1], min);
                }
                matrix[i][j] += min;
            }
        }
        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}