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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return ans;
        
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> toTraverse = new ArrayList<>();
            List<Integer> levelVal = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                toTraverse.add(curr);
                levelVal.add(curr.val);
            }
            for (TreeNode curr : toTraverse) {
                if (curr.left !=null) queue.add(curr.left);
                if (curr.right !=null) queue.add(curr.right);
            }
            ans.add(levelVal);
        }
        return ans;
    }
}