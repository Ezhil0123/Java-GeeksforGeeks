class Solution {
    int n, m;
    int[][][] dp;
    public int maxChocolate(int grid[][]) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 0, m - 1, grid);
    }
    private int solve(int row, int col1, int col2, int[][] grid) {
        if (col1 < 0 || col2 < 0 || col1 >= m || col2 >= m)
            return (int)-1e8;
        if (row == n - 1) {
            if (col1 == col2)
                return grid[row][col1];
            else
                return grid[row][col1] + grid[row][col2];
        }
        if (dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        int max = 0;
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                int value;
                if (col1 == col2)
                    value = grid[row][col1];
                else
                    value = grid[row][col1] + grid[row][col2];
                value += solve(row + 1, col1 + d1, col2 + d2, grid);
                max = Math.max(max, value);
            }
        }
        return dp[row][col1][col2] = max;
    }
}