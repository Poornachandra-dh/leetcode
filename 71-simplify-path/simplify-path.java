import java.util.*;

class Solution {
    public String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty parts and "."
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pollLast();
                }

            } else {
                // Normal directory
                stack.addLast(part);
            }
        }

        // Build final path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        // If stack is empty, return root
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}