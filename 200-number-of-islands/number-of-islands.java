class Solution {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {

                    count++;

                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col) {

        // Outside the grid
        if (row < 0 || row >= grid.length ||
            col < 0 || col >= grid[0].length) {

            return;
        }

        // Water or already visited
        if (grid[row][col] == '0') {
            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        // Up
        dfs(grid, row - 1, col);

        // Down
        dfs(grid, row + 1, col);

        // Left
        dfs(grid, row, col - 1);

        // Right
        dfs(grid, row, col + 1);
    }
}