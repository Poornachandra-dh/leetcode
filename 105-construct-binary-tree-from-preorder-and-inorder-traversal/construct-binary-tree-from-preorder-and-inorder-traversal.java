class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder value -> index
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inStart, int inEnd) {

        // No elements
        if (inStart > inEnd) {
            return null;
        }

        // First element of preorder is the root
        int rootValue = preorder[preIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // Build left subtree first
        root.left = build(preorder, inStart, rootIndex - 1);

        // Build right subtree
        root.right = build(preorder, rootIndex + 1, inEnd);

        return root;
    }
}