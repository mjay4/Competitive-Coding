/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {

    Node startingNode;

    public Node flipBinaryTree(Node root, Node leaf) {
        startingNode = root;
        return flip(leaf,null); 
    }

    public Node flip(Node curr, Node newParent) {
        Node oldParent = curr.parent;
        curr.parent = newParent;

        if (curr.left == newParent) curr.left = null;
        if (curr.right == newParent) curr.right = null;

        if (curr == startingNode) return curr;

        if (curr.left != null) curr.right = curr.left;
        curr.left = flip(oldParent,curr);

        return curr;
    }
}