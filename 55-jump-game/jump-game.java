class Solution {
    public boolean canJump(int[] nums) {

        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Cannot reach this index
            if (i > maxReach) {
                return false;
            }

            // Update the farthest position we can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // Already reached the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}