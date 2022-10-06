package leetcode.question0111;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        int minDepth = minDepth(root);
        System.out.println(minDepth);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int minDepth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left == null && current.right == null) {
                    return minDepth;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            minDepth++;
        }

        return minDepth;
    }
}
