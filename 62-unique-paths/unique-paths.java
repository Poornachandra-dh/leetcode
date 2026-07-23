/*class Solution {

    public int uniquePaths(int m, int n) {
        return path(0, 0, m, n);
    }

    public int path(int row, int col, int m, int n) {

        if (row == m - 1 && col == n - 1)
            return 1;

        if (row >= m || col >= n)
            return 0;

        int rightWays = path(row, col + 1, m, n);
        int downWays = path(row + 1, col, m, n);

        return rightWays + downWays;
    }
}
*/

class Solution {

    int[][] dp;

    public int uniquePaths(int m, int n) {

        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return path(0, 0, m, n);
    }

    public int path(int row, int col, int m, int n) {

        if (row == m - 1 && col == n - 1)
            return 1;

        if (row >= m || col >= n)
            return 0;

        // Already computed
        if (dp[row][col] != -1)
            return dp[row][col];

        int rightWays = path(row, col + 1, m, n);
        int downWays = path(row + 1, col, m, n);

        dp[row][col] = rightWays + downWays;

        return dp[row][col];
    }
}