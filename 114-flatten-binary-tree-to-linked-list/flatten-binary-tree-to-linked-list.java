class Solution {

    TreeNode prev = null;

    public void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        // Reverse preorder: Right -> Left -> Root
        flatten(root.right);
        flatten(root.left);

        // Connect current node to previously processed node
        root.right = prev;
        root.left = null;

        // Current node becomes previous
        prev = root;
    }
}