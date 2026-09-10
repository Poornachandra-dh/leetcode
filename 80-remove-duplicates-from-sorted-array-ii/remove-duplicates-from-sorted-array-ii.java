class Solution {
    public int removeDuplicates(int[] nums) {

        int k = 0;

        for (int num : nums) {

            // First two elements are always allowed
            // Otherwise, compare with the element 2 positions back
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}