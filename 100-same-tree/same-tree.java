class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both are empty
        if (p == null && q == null) {
            return true;
        }

        // One is empty, other is not
        if (p == null || q == null) {
            return false;
        }

        // Values must match
        // Left subtrees must match
        // Right subtrees must match
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}