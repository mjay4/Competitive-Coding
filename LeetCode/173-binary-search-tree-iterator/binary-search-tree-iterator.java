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
class BSTIterator {

    TreeNode currentPointer;
    Stack<Integer> stack;

    public BSTIterator(TreeNode root) {
        this.currentPointer = root;
        stack = new Stack<>();
        dfs(currentPointer);
    }
    
    public int next() {
        return stack.pop();
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        dfs(node.right);
        stack.push(node.val);
        dfs(node.left);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */