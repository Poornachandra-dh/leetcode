class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int low = 0;
        int high = s.length() - 1;

        while(low < high) {

            if(!Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            }
            else if(!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            }
            else {

                if(s.charAt(low) != s.charAt(high)) {
                    return false;
                }

                low++;
                high--;
            }
        }

        return true;
    }
}