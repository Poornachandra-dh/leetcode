class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // Start from the LAST element of postorder
        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // Last element of postorder = root
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // IMPORTANT: Build RIGHT first
        root.right = build(inorder, postorder,
                           rootIndex + 1, right);

        // Then build LEFT
        root.left = build(inorder, postorder,
                          left, rootIndex - 1);

        return root;
    }
}