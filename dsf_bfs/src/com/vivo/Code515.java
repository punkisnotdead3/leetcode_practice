package com.vivo;

import java.util.*;

public class Code515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int array[] = new int[sz];
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                array[i] = cur.val;
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
            Arrays.sort(array);
            result.add(array[array.length - 1]);
        }
        return result;
    }


    public List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        while (!queue.isEmpty()) {
            int sz = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                max = Integer.max(max, cur.val);
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
            result.add(max);
        }
        return result;
    }

    //public void bfs()
}
