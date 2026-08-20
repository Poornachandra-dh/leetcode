import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        // Base index before the current valid substring
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // Store index of '('
                stack.push(i);

            } else {

                // Remove matching '('
                stack.pop();

                if (stack.isEmpty()) {

                    // Current ')' cannot be matched
                    stack.push(i);

                } else {

                    // Length of valid substring
                    int length = i - stack.peek();

                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength;
    }
}