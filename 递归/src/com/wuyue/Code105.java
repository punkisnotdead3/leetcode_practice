package com.wuyue;

/**
 * https://www.bilibili.com/video/BV1UJ411c75f?from=search&seid=13515599032462363317&spm_id_from=333.337.0.0
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 *
 */
public class Code105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeSub(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTreeSub(int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end) {
        if (preorder_start == preorder_end) {
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[preorder_start]);
        int index = 0;
        // 这里有个优化是 可以先把inorder数组的下标和实际的值 放到一个map中 这样免的后面每次都循环
        for (int i = inorder_start; i < inorder_end; i++) {
            if (inorder[i] == treeNode.val) {
                index = i;
            }
        }
        // 复杂就复杂在下面的索引计算的方法
        int left = index - inorder_start;
        treeNode.left = buildTreeSub(preorder, inorder, preorder_start + 1, preorder_start + left + 1, inorder_start, inorder_start + left);
        treeNode.right = buildTreeSub(preorder, inorder, preorder_start + left + 1, preorder_end, index + 1, inorder_end);
        return treeNode;
    }

}
