import java.util.*;

class Solution {

    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<Integer> list = new ArrayList<>();

        backtrack(0, candidates, target, list);

        return ans;
    }

    public void backtrack(int index, int[] candidates, int target, List<Integer> list) {

        // Target achieved
        if (target == 0) {

            List<Integer> temp = new ArrayList<Integer>();

            for (int i = 0; i < list.size(); i++) {
                temp.add(list.get(i));
            }

            ans.add(temp);
            return;
        }

        // Invalid case
       if (target < 0 || index == candidates.length) {
            return;
       }

        // Choose current number
        list.add(candidates[index]);

        backtrack(index, candidates, target - candidates[index], list);

        // Backtrack
        list.remove(list.size() - 1);

        // Skip current number
        backtrack(index + 1, candidates, target, list);
    }
}