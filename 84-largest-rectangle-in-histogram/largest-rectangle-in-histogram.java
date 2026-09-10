import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        // Extra iteration acts like a 0-height bar
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