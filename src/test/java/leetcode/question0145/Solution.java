package leetcode.question0145;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    @Test
    void test() {
        postorderTraversal(null);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}
