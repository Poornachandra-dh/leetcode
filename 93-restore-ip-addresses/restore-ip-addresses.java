import java.util.*;

class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> result = new ArrayList<>();

        // An IP has 4 parts, each with at most 3 digits
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String s, int index,
                           List<String> parts,
                           List<String> result) {

        // We have 4 parts
        if (parts.size() == 4) {

            // All characters must be used
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }

            return;
        }

        // Try taking 1, 2, or 3 digits
        for (int end = index;
             end < s.length() && end < index + 3;
             end++) {

            // Leading zero is not allowed
            if (end > index && s.charAt(index) == '0') {
                break;
            }

            String part = s.substring(index, end + 1);

            // Convert to number
            int value = Integer.parseInt(part);

            // Must be between 0 and 255
            if (value > 255) {
                break;
            }

            // Choose
            parts.add(part);

            // Explore
            backtrack(s, end + 1, parts, result);

            // Undo
            parts.remove(parts.size() - 1);
        }
    }
}