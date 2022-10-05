package datastructure.tree;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9);
        root.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(5);
        root.left.right =  new TreeNode(8);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(13);

        // TreeNode node = get(root, 3);
        // System.out.println(node);

        // TreeNode node = insert(root, 10);
        // System.out.println(node.val);

        // preorder traversal
        // preOrderTraversal(root);

        // inorder traversal
        // inOrderTraversal(root);

        // postorder traversal
        postOrderTraversal(root);
    }

    public static TreeNode get(TreeNode root, int key) {
        TreeNode current = root;
        while (current != null && current.val != key) {
            if (key > current.val) {
                current = current.right;
            } else if (key < current.val) {
                current = current.left;
            }
        }

        return current != null ? current : null;
    }

    public static TreeNode insert(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        TreeNode current = root;
        TreeNode parent;
        while (true) {
            parent = current;
            if (key < parent.val) {
                current = parent.left;
                if (current == null) {
                    parent.left = new TreeNode(key);
                    return root;
                }
            } else if (key > parent.val) {
                current = parent.right;
                if (current == null) {
                    parent.right = new TreeNode(key);
                    return root;
                }
            } else {
                // BST does not allow the nodes with same values
                return root;
            }
        }
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " -> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " -> ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(root.val + " -> ");
    }
}
