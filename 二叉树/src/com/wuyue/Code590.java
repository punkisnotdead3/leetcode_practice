package com.wuyue;

import java.util.ArrayList;
import java.util.List;

//后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
public class Code590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        order(root, res);
        return res;
    }

    public void order(Node root, List<Integer> res) {
        if (root == null) {
           return;
        }
        for (Node node : root.children) {
            order(node, res);
        }
        res.add(root.val);
    }
}
