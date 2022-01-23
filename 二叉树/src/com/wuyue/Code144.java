package com.wuyue;

import java.util.ArrayList;
import java.util.List;

/**
 * todo https://www.cnblogs.com/du001011/p/11229170.html
 * 前序遍历  根结点-左结点-右结点
 */
public class Code144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        order(root,res);
        return res;
    }

    public void order(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        order(root.left, res);
        order(root.right, res);
    }
}
