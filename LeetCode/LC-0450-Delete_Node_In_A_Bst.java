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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(key<root.val)
            root.left = deleteNode(root.left,key);
        else if(key>root.val){
            root.right = deleteNode(root.right, key);
        }else{
            root = helper(root,key);
        }
        return root;
    }
    public TreeNode helper(TreeNode root, int key){
        if(root== null || (root.val==key && root.left==null && root.right==null) )
		  return null;
		if(root.val == key && root.left == null)
		    root = root.right;
		else if(root.val ==key && root.right == null)
		    root = root.left;
		else{
		    TreeNode min = findSmallest(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, root.val);
		}
		return root;
    }
    public TreeNode findSmallest(TreeNode node){
	     while(node.left != null){
        node = node.left;
    }
    return node;
	}
}