class Solution {
    int total =0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return total;
        if(root.left!=null){
            if(root.left.left == null && root.left.right ==null)
                total += root.left.val;
            sumOfLeftLeaves(root.left);
        }
        if(root.right!=null)
            sumOfLeftLeaves(root.right);
        return total;
    }
}