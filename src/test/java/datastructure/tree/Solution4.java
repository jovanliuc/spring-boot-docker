package datastructure.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    List<Integer> result = new ArrayList<>();

    @Test
    void test() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right =  new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        List<Integer> result = preorderTraverse(root);
        System.out.println(result.size());
    }

    private List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return result;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
