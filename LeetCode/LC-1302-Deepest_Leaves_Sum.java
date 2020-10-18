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
    /*
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            sum = 0; // Reset for calculating the sum of elements of the next level
            while (size-- > 0) {
                TreeNode top = q.poll();
                sum += top.val;
                if (top.left != null) q.offer(top.left);
                if (top.right != null) q.offer(top.right);
            }
        }
        return sum;
    }
    */
    ///*  Faster Implementation, but uses array.
    int[] val;
    public int deepestLeavesSum(TreeNode root) {
        val = new int[10001];
        search(root,0);
        for(int i = 0; i<10000; i++){
            if(val[i+1] == 0)
                return val[i];
        }
        return -1;
    }
    public void search(TreeNode root,int cur){
        if(root==null)
            return;
        val[cur]+=root.val;
        search(root.left,cur+1);
        search(root.right,cur+1);
    }
   // */
}