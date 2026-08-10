import java.util.*;

class Solution {

    public long smallestNumber(long num) {

        // Case 1: num is 0
        if (num == 0) {
            return 0;
        }

        // Case 2: negative number
        if (num < 0) {

            num = -num;

            String s = String.valueOf(num);

            char[] digits = s.toCharArray();

            Arrays.sort(digits);

            StringBuilder sb = new StringBuilder();

            // Put digits in descending order
            for (int i = digits.length - 1; i >= 0; i--) {
                sb.append(digits[i]);
            }

            return -Long.parseLong(sb.toString());
        }

        // Case 3: positive number
        String s = String.valueOf(num);

        char[] digits = s.toCharArray();

        Arrays.sort(digits);

        // Find the first non-zero digit
        int first = 0;

        while (digits[first] == '0') {
            first++;
        }

        // Put the first non-zero digit first
        StringBuilder sb = new StringBuilder();

        sb.append(digits[first]);

        // Add remaining digits
        for (int i = 0; i < digits.length; i++) {

            if (i != first) {
                sb.append(digits[i]);
            }
        }

        return Long.parseLong(sb.toString());
    }
}