class Solution {
    public String minWindow(String s, String t) {

        int[] need = new int[128];
        int[] window = new int[128];

        // Count characters required from t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);
            window[c]++;

            // This character is still needed
            if (window[c] <= need[c]) {
                count++;
            }

            // Window contains all characters of t
            while (count == t.length()) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove left character
                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (window[leftChar] < need[leftChar]) {
                    count--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLength);
    }
}