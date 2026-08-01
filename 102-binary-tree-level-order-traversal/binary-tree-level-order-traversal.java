/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
    public static int level(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(level(root.left), level(root.right));
    }
    private void nth_level(TreeNode root, int level, int lvl,List<Integer>arr){
        if(root==null) return;
        if(level==lvl) arr.add(root.val);
        nth_level(root.left,level+1,lvl,arr);
        nth_level(root.right,level+1,lvl,arr);
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>>ans=new ArrayList<>();
    int lvl=level(root);
    for(int i=0;i<=lvl-1;i++){
        List<Integer>arr=new ArrayList<>();
        nth_level( root,0,i,arr);
        ans.add(arr);
    }    
    return ans;
    }
}
