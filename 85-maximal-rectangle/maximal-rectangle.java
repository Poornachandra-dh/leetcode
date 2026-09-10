import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];

        int maxArea = 0;

        for (int row = 0; row < matrix.length; row++) {

            // Build histogram
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    heights[col] = 0;
                }
            }

            // Find largest rectangle in this histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            while (!stack.isEmpty() &&
                   (i == heights.length ||
                    heights[stack.peek()] > heights[i])) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            if (i < heights.length) {
                stack.push(i);
            }
        }

        return maxArea;
    }
}