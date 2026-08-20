import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Sets for rows, columns and 3x3 boxes
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Check row
                if (!rows[r].add(num)) {
                    return false;
                }

                // Check column
                if (!cols[c].add(num)) {
                    return false;
                }

                // Find 3x3 box
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check box
                if (!boxes[boxIndex].add(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}