class Solution {

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    // Height of tree
    public int level(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(level(root.left), level(root.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null)
            return 0;

        int mydia = level(root.left) + level(root.right);

        int leftdia = diameterOfBinaryTree(root.left);

        int rightdia = diameterOfBinaryTree(root.right);

        return max(mydia, leftdia, rightdia);
    }
}