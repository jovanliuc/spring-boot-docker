package leetcode.question0543;

import org.junit.jupiter.api.Test;

public class Solution {

    int maxDiameter = 0;

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right =  new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        int maxDiameter = diameterOfBinaryTree(root);
        System.out.println("The maximum diameter of binary tree is " + maxDiameter);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter(root);
        return maxDiameter;
    }

    private int maxDiameter(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftDiameter = maxDiameter(root.left);
        int maxRightDiameter = maxDiameter(root.right);
        maxDiameter = maxLeftDiameter + maxRightDiameter > maxDiameter ? maxLeftDiameter + maxRightDiameter : maxDiameter;
        return maxLeftDiameter > maxRightDiameter ? maxLeftDiameter + 1 : maxRightDiameter + 1;
    }
}
