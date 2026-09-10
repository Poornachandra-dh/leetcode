class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n + 1];

        // Empty tree
        dp[0] = 1;

        for (int nodes = 1; nodes <= n; nodes++) {

            // Try every possible root
            for (int root = 1; root <= nodes; root++) {

                int left = root - 1;
                int right = nodes - root;

                dp[nodes] += dp[left] * dp[right];
            }
        }

        return dp[n];
    }
}