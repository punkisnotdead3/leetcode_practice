package com.wuyue;

public class Code226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if (node== null) {
            return;
        }
        TreeNode tmp = node.right;
        node.right = node.left;
        node.left = tmp;
        invert(node.left);
        invert(node.right);

    }

}
