class Solution {

    public String reverseWords(String s) {

        StringBuilder ans = new StringBuilder();

        int n = s.length();

        // reverse full string
        for (int i = n - 1; i >= 0; i--) {
            ans.append(s.charAt(i));
        }

        int i = 0;

        while (i < ans.length()) {

            while (i < ans.length() && ans.charAt(i) == ' ') {
                i++;
            }

            int j = i;

            while (j < ans.length() && ans.charAt(j) != ' ') {
                j++;
            }

            int a = i;
            int b = j - 1;

            while (a < b) {

                char temp = ans.charAt(a);

                ans.setCharAt(a, ans.charAt(b));
                ans.setCharAt(b, temp);

                a++;
                b--;
            }

            i = j;
        }

        String[] words = ans.toString().trim().split("\\s+");

        String res = "";

        for (int k = 0; k < words.length; k++) {

            res += words[k];

            if (k != words.length - 1) {
                res += " ";
            }
        }

        return res;
    }
}