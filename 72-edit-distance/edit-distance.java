class Solution {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Convert word1[0...i] to empty string
        // We need i deletions
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert empty string to word2[0...j]
        // We need j insertions
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // Characters are same
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    // Replace
                    int replace = dp[i - 1][j - 1];

                    // Delete
                    int delete = dp[i - 1][j];

                    // Insert
                    int insert = dp[i][j - 1];

                    dp[i][j] = 1 + Math.min(
                        replace,
                        Math.min(delete, insert)
                    );
                }
            }
        }

        return dp[m][n];
    }
}