package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution2 {

    int maxDepth = 0;
    int depth = 0;

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

        depth++;
        if (root.left == null && root.right == null) {
            maxDepth = depth > maxDepth ? depth : maxDepth;
        }
        traverse(root.left);
        traverse(root.right);
        depth--;
    }
}
