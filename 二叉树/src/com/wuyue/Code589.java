package com.wuyue;

import java.util.ArrayList;
import java.util.List;

public class Code589 {
    //考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(根左右)
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        order(root, res);
        return res;
    }

    public void order(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            order(node, res);
        }
    }
}
