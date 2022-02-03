package com.wuyue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.bilibili.com/video/BV12Z4y15721?from=search&seid=5256824369772226023&spm_id_from=333.337.0.0
 * <p>
 * 这个题的算法思路就是  先用dfs遍历出来 2个节点的路径
 * <p>
 * 然后找一下 路径上最近的那个即可
 */
public class Code236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        List<TreeNode> temp = new ArrayList<>();

        dfs(root, p, pPath, temp);
        temp.clear();
        dfs(root, q, qPath, temp);

        for (int i = 0; i < pPath.size(); i++) {
            if (qPath.size() <= i || (pPath.get(i) != qPath.get(i))) {
                return pPath.get(i - 1);
            }
        }

        return pPath.get(pPath.size() - 1);
    }

    public void dfs(TreeNode root, TreeNode search, List<TreeNode> path, List<TreeNode> temp) {
        if (root == null) {
            return;
        }
        temp.add(root);
        // 找到以后 就 把路径结点都存储起来
        if (root == search) {
            path.addAll(temp);
            return;
        }
        dfs(root.left, search, path, temp);
        dfs(root.right, search, path, temp);
        // 这一步很关键，要把多余的干掉
        temp.remove(temp.size() - 1);

    }

    public static void main(String[] args) {

        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t1 = new TreeNode(1);
        TreeNode t6 = new TreeNode(6);
        TreeNode t2 = new TreeNode(2);
        TreeNode t0 = new TreeNode(0);
        TreeNode t8 = new TreeNode(8);
        TreeNode t7 = new TreeNode(7);
        TreeNode t4 = new TreeNode(4);

        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;
        t1.right = t8;
        t1.left = t0;


        Code236 cc = new Code236();
        cc.lowestCommonAncestor(t3, t5, t4);
    }
}
