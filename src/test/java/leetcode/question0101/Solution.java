package leetcode.question0101;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(40);
        root.right.right = new TreeNode(30);

        isSymmetric(root);
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } 
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
