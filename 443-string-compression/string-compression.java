class Solution {

    public int compress(char[] chars) {

        int write = 0;
        int i = 0;

        while (i < chars.length) {

            char current = chars[i];

            int count = 0;

            // Count same characters
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }

            // Write the character
            chars[write] = current;
            write++;

            // Write the count
            if (count > 1) {

                String number = String.valueOf(count);

                for (int j = 0; j < number.length(); j++) {
                    chars[write] = number.charAt(j);
                    write++;
                }
            }
        }

        return write;
    }
}