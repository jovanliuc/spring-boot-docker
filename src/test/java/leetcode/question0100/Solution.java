package leetcode.question0100;

import org.junit.jupiter.api.Test;

public class Solution {

    @Test
    void test() {
        TreeNode p = new TreeNode(10);
        p.left = new TreeNode(20);
        p.right = new TreeNode(30);

        TreeNode q = new TreeNode(10);
        q.left = new TreeNode(20);
        q.right = new TreeNode(30);
        
        isSameTree(p, q);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } 
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
