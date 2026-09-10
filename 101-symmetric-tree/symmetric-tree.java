class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode a, TreeNode b) {

        // Both are empty
        if (a == null && b == null) {
            return true;
        }

        // One is empty
        if (a == null || b == null) {
            return false;
        }

        // Values are different
        if (a.val != b.val) {
            return false;
        }

        // Compare mirror positions
        return isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }
}