package com.wuyue;

public class Code104 {

    // 这道题 其实就巧妙在  二叉树的深度 就是 每往下面一层就+1 所以深度就是n次 递归的+1 即可
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
