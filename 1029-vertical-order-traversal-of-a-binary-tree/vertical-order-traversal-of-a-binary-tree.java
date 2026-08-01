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

    class Pair {
        int row;
        int val;

        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    TreeMap<Integer, List<Pair>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        dfs(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Pair> list : map.values()) {

            Collections.sort(list, (a, b) -> {
                if (a.row == b.row)
                    return a.val - b.val;
                return a.row - b.row;
            });

            List<Integer> temp = new ArrayList<>();

            for (Pair p : list)
                temp.add(p.val);

            ans.add(temp);
        }

        return ans;
    }

    void dfs(TreeNode root, int row, int col) {

        if (root == null)
            return;

        map.putIfAbsent(col, new ArrayList<>());

        map.get(col).add(new Pair(row, root.val));

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }
}