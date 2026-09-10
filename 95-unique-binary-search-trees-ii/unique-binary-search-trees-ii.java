class Solution {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // No nodes
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every value as root
        for (int i = start; i <= end; i++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = generate(start, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = generate(i + 1, end);

            // Combine every left tree with every right tree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}