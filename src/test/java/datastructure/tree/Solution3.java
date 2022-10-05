package datastructure.tree;

import org.junit.jupiter.api.Test;

public class Solution3 {

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

        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxLeftDepth = maxDepth(root.left);
        int maxRightDepth = maxDepth(root.right);

        return maxLeftDepth > maxRightDepth ? maxLeftDepth + 1 : maxRightDepth + 1;
    }
}
