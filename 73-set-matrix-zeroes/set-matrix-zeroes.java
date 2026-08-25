/*class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] helper = new int[m][n];

        // Copy original matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                helper[i][j] = arr[i][j];
            }
        }

        // Find original zeroes
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (helper[i][j] == 0) {

                    // Make entire row zero
                    for (int a = 0; a < n; a++) {
                        arr[i][a] = 0;
                    }

                    // Make entire column zero
                    for (int b = 0; b < m; b++) {
                        arr[b][j] = 0;
                    }
                }
            }
        }
    }
}*/

class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row contains 0
        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) {
                firstRowZero = true;
            }
        }

        // Check if first column contains 0
        for (int i = 0; i < m; i++) {
            if (arr[i][0] == 0) {
                firstColZero = true;
            }
        }

        // Use first row and first column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        // Set rows to zero
        for (int i = 1; i < m; i++) {
            if (arr[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        // Set columns to zero
        for (int j = 1; j < n; j++) {
            if (arr[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    arr[i][j] = 0;
                }
            }
        }

        // Finally handle first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                arr[0][j] = 0;
            }
        }

        // Finally handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                arr[i][0] = 0;
            }
        }
    }
}