package com.wuyue;

import java.util.ArrayList;
import java.util.List;

public class Code429 {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        order(result, root, 0);
        return result;
    }

    private void order(List<List<Integer>> result, Node root, int level) {
        if (root == null) {
            return;
        }
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        for (Node node : root.children) {
            order(result, node, level + 1);
        }
    }
}
