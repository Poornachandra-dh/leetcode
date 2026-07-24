class Solution {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Sign
        int sign = 1;

        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            i++;
        }

        int num = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Overflow check
            if (num > (Integer.MAX_VALUE - digit) / 10) {

                if (sign == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }

            num = num * 10 + digit;

            i++;
        }

        return sign * num;
    }
}