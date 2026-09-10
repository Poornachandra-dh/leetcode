class Solution {
    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {

                if (dfs(board, word, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int row, int col, int index) {

        // Out of bounds
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character doesn't match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Entire word matched
        if (index == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in 4 directions
        boolean found =
                dfs(board, word, row + 1, col, index + 1) || // Down
                dfs(board, word, row - 1, col, index + 1) || // Up
                dfs(board, word, row, col + 1, index + 1) || // Right
                dfs(board, word, row, col - 1, index + 1);   // Left

        // Backtrack: restore original character
        board[row][col] = temp;

        return found;
    }
}