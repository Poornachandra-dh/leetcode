/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean exists(TreeNode root, TreeNode Node){
        if(root==null) return false;
        if(Node==root) return true;
        return exists(root.left,Node)||exists(root.right,Node);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==root || q==root) return root;
        boolean pLiesInLST= exists(root.left,p);
        boolean qLiesInLST= exists(root.left,q);
        if(pLiesInLST==true && qLiesInLST==true)
        return lowestCommonAncestor(root.left,p,q);
        if(pLiesInLST==false && qLiesInLST==false)
         return lowestCommonAncestor(root.right,p,q);
         if(pLiesInLST==true && qLiesInLST==false) return root;
         if(pLiesInLST==false && qLiesInLST==true) return root;
         else return root;
    }
}