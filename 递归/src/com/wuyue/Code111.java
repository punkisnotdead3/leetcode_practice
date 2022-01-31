package com.wuyue;

public class Code111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果只有root 一个结点 那么就直接就是1
        if (root.left == null && root.right == null) return 1;
        int leftD = minDepth(root.left);
        int rightD = minDepth(root.right);
        if (root.left == null || root.right == null) return leftD + rightD + 1;
        return Math.min(leftD, rightD) + 1;
    }
}
