class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // both are null
        if (p == null && q == null)
            return true;

        // one is null
        if (p == null || q == null)
            return false;

        // values not equal
        if (p.val != q.val)
            return false;

        // check left and right subtree
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}
















































