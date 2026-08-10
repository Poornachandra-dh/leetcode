
class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        String str = "";

        int n = s.length();

        for (int i = 0; i < n; i++) {

            int ascii = s.charAt(i);

            if ((ascii >= 97 && ascii <= 122) ||
                (ascii >= 48 && ascii <= 57)) {

                char ch = (char) ascii;
                str += ch;
            }
        }

        char[] arr = str.toCharArray();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {

            if (arr[i] != arr[j]) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}