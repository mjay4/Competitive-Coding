/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
boolean check(Node root, int min, int max) {
    if (root != null) {
        if (root.data >= max || root.data <= min) {
            return false;
        }
        else {
            return check(root.left, min, root.data) & check(root.right, root.data, max);
        }   
    }
    else {
        return true;
    }
}

boolean checkBST(Node root) {
    return check(root, 0, Integer.MAX_VALUE);
}
   