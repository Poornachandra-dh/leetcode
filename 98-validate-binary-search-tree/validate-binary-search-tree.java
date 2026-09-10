class Solution {

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {

        // Empty tree/subtree is valid
        if (node == null) {
            return true;
        }

        // Current node must be inside the valid range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Left subtree:
        // values must be smaller than node.val
        boolean left = validate(node.left, min, node.val);

        // Right subtree:
        // values must be greater than node.val
        boolean right = validate(node.right, node.val, max);

        return left && right;
    }
}