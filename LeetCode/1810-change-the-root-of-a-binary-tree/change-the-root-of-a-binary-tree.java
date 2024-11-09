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
        // Placeholder for oldParent. 
        Node oldParent = curr.parent;
        curr.parent = newParent;

        // Rest the curr if it is pointing to newParent. 
        if (curr.left == newParent) curr.left = null;
        if (curr.right == newParent) curr.right = null;

        // If we have reached the root, we should return. 
        if (curr == startingNode) return curr;

        // Left should go to right and then left would become the flip of oldParent and curr. 
        if (curr.left != null) curr.right = curr.left;
        curr.left = flip(oldParent,curr);

        return curr;
    }
}