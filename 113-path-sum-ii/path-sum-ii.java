class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return result;
    }

    private void dfs(TreeNode node, int remaining) {

        if (node == null) {
            return;
        }

        // Add current node
        path.add(node.val);

        // Check if current node is a leaf
        if (node.left == null && node.right == null
                && remaining == node.val) {

            result.add(new ArrayList<>(path));
        }

        // Explore left and right
        dfs(node.left, remaining - node.val);
        dfs(node.right, remaining - node.val);

        // Backtrack
        path.remove(path.size() - 1);
    }
}