/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static int level(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(level(root.left), level(root.right));
    }

    private void nth_level(TreeNode root, int currentLevel, int targetLevel, List<Integer> arr) {
        if (root == null) return;
        if (currentLevel == targetLevel) {
            arr.add(root.val);
            return;
        }
        nth_level(root.left, currentLevel + 1, targetLevel, arr);
        nth_level(root.right, currentLevel + 1, targetLevel, arr);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int totalLevels = level(root);

        for (int i = 0; i < totalLevels; i++) {
            List<Integer> arr = new ArrayList<>();
            nth_level(root, 0, i, arr);

            // Reverse the list for zigzag order at odd levels
            if (i % 2 != 0) {
               Collections.reverse(arr);
               
            }

            ans.add(arr);
        }
        return ans;
    }
}
