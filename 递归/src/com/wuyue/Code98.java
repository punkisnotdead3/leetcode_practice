package com.wuyue;

public class Code98 {

    long pre = Long.MIN_VALUE;

    // bst的题目都是中序遍历 左 根 右   因为 bst的 要求就是 left<root<right 所以按照这个遍历就可以了
    // 这题要注意的是 左字树的全部子结点 都要比 root 小
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);

    }


}
