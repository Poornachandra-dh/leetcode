class Solution {
    public boolean isNumber(String s) {

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Digit
            if (c >= '0' && c <= '9') {
                seenDigit = true;
            }

            // Decimal point
            else if (c == '.') {

                // Dot cannot appear twice
                // Dot cannot appear after e/E
                if (seenDot || seenExp) {
                    return false;
                }

                seenDot = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {

                // Only one e/E
                // Number must exist before e/E
                if (seenExp || !seenDigit) {
                    return false;
                }

                seenExp = true;

                // We need digits after e/E
                seenDigit = false;
            }

            // + or -
            else if (c == '+' || c == '-') {

                // Sign is allowed only:
                // 1. At the beginning
                // 2. Immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e'
                           && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            // Anything else is invalid
            else {
                return false;
            }
        }

        // Must have digits at the end
        return seenDigit;
    }
}