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
    public int levels(TreeNode root, boolean[] ans) {
        if (root == null) return 0;

        int leftHeight = levels(root.left, ans);
        int rightHeight = levels(root.right, ans);

        // If a subtree is already unbalanced, return immediately
        if (!ans[0]) return -1;

        // Check the balance condition
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }

        // Return the height of the current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        boolean[] ans = {true};
        levels(root, ans);
        return ans[0];
    }
}
