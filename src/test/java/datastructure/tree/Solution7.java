package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution7 {

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right =  new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        int count = count(root);
        System.out.println("The total count of tree node is " + count);
    }

    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        System.out.println("The tree node of " + root.val + " have the " + leftCount + " left tree nodes " + " and " + rightCount + " right tree nodes");

        return leftCount + rightCount + 1;
    }
}
