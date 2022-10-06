package leetcode.question0112;

import org.junit.jupiter.api.Test;

public class Solution {

    int target;
    int sum;
    boolean found;

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        hasPathSum(root, 100);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.target = targetSum;
        traverse(root);
        return found;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (root.left == null && root.right == null && sum == this.target) {
            found = true;
            return;
        }
        traverse(root.left);
        traverse(root.right);
        sum -= root.val;
    }
}
