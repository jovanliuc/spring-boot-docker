package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution6 {

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right =  new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        traverse(root, 1);
    }

    void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " is located in the " + level + " level");
        traverse(root.left,  level + 1);
        traverse(root.right, level + 1);
    }
}
