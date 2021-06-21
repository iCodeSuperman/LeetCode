package second;

/**
 * 221 最大正方形
 */
public class Q221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length <= 0 || matrix[0].length <= 0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < cols + 1; j++) {
                // 不要忘了判定条件是这个哦
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }

        return maxSide * maxSide;
    }
}
