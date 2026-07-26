import java.util.*;

class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<Integer>();

        backtrack(0, nums, list);

        return ans;
    }

    public void backtrack(int index, int[] nums, List<Integer> list) {

        // Create a copy of the current subset
        List<Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < list.size(); i++) {
            temp.add(list.get(i));
        }

        ans.add(temp);

        // Generate subsets
        for (int i = index; i < nums.length; i++) {

            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            list.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, list);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }
}