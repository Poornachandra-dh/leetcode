import java.util.*;

class Solution {

    List<List<String>> ans = new ArrayList<List<String>>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, board);

        return ans;
    }

    public void backtrack(int row, char[][] board) {

        if (row == board.length) {

            List<String> temp = new ArrayList<String>();

            for (int i = 0; i < board.length; i++) {
                temp.add(new String(board[i]));
            }

            ans.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(row, col, board)) {

                board[row][col] = 'Q';

                backtrack(row + 1, board);

                board[row][col] = '.';
            }
        }
    }

    public boolean isSafe(int row, int col, char[][] board) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // Check left diagonal
        int r = row;
        int c = col;

        while (r >= 0 && c >= 0) {

            if (board[r][c] == 'Q')
                return false;

            r--;
            c--;
        }

        // Check right diagonal
        r = row;
        c = col;

        while (r >= 0 && c < board.length) {

            if (board[r][c] == 'Q')
                return false;

            r--;
            c++;
        }

        return true;
    }
}