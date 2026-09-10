class Solution {

    private String s1;
    private String s2;
    private Boolean[][][] memo;

    public boolean isScramble(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        this.s1 = s1;
        this.s2 = s2;

        int n = s1.length();

        memo = new Boolean[n][n][n + 1];

        return dfs(0, 0, n);
    }

    private boolean dfs(int i, int j, int len) {

        // Already calculated
        if (memo[i][j][len] != null) {
            return memo[i][j][len];
        }

        // Same substring
        if (s1.substring(i, i + len)
             .equals(s2.substring(j, j + len))) {

            return memo[i][j][len] = true;
        }

        // Check if both substrings contain
        // the same characters
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int value : count) {
            if (value != 0) {
                return memo[i][j][len] = false;
            }
        }

        // Try every possible split
        for (int split = 1; split < len; split++) {

            // Case 1: Don't swap
            boolean noSwap =
                dfs(i, j, split) &&
                dfs(i + split, j + split, len - split);

            if (noSwap) {
                return memo[i][j][len] = true;
            }

            // Case 2: Swap
            boolean swap =
                dfs(i, j + len - split, split) &&
                dfs(i + split, j, len - split);

            if (swap) {
                return memo[i][j][len] = true;
            }
        }

        return memo[i][j][len] = false;
    }
}