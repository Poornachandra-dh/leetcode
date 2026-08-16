class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int originalColor = image[sr][sc];

        // If colors are already the same, nothing to do
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(
            int[][] image,
            int row,
            int col,
            int originalColor,
            int newColor) {

        // Boundary check
        if (row < 0 || row >= image.length ||
            col < 0 || col >= image[0].length) {
            return;
        }

        // Only change cells having the original color
        if (image[row][col] != originalColor) {
            return;
        }

        // Fill current cell
        image[row][col] = newColor;

        // Up
        dfs(image, row - 1, col, originalColor, newColor);

        // Down
        dfs(image, row + 1, col, originalColor, newColor);

        // Left
        dfs(image, row, col - 1, originalColor, newColor);

        // Right
        dfs(image, row, col + 1, originalColor, newColor);
    }
}