
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        ArrayList<Integer> ans = new ArrayList<>();

        while (left <= right && top <= bottom) {

            // 1. Left to right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // 2. Top to bottom
            for (int j = top; j <= bottom; j++) {
                ans.add(matrix[j][right]);
            }
            right--;

            // 3. Right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // 4. Bottom to top
            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    ans.add(matrix[j][left]);
                }
                left++;
            }
        }

        return ans;
    }
}
