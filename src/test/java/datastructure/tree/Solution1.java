package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution1 {

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right =  new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        traverse(root);
    }

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // the location of pre-order
        // System.out.print(root.val + " -> ");
        traverse(root.left);
        // the location of in-order
        // System.out.print(root.val + " -> ");
        traverse(root.right);
        // the location of post-order
        // System.out.print(root.val + " -> ");
    }
}
