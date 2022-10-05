package leetcode.question0104;

import org.junit.jupiter.api.Test;

public class Solution1 {

    int maxDepth = 0;
    int depth = 0;

    @Test
    void test() {
        maxDepth(null);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeftDepth = maxDepth0(root.left);
        int maxRightDepth = maxDepth0(root.right);
        maxDepth = maxLeftDepth > maxRightDepth ? maxLeftDepth + 1 : maxRightDepth + 1;
        return maxDepth;
    }

    private int maxDepth0(TreeNode root) {
        maxDepth1(root);
        return maxDepth;
    }

    private void maxDepth1(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++;
        maxDepth1(root.left);
        maxDepth = depth > maxDepth ? depth : maxDepth;
        maxDepth1(root.right);
        depth--;
    }
}
