package com.company;

import java.util.HashSet;
import java.util.Set;

public class Code142 {
    /**
     *  这个题目的双指针解法 很难理解。我直接跳过。。。。
     *
     *  用set来做则很简单了，
     *
     *  循环 往set 里面 丢node，
     *  判断有这个node 则有环，直接返回当前结点即可。
     *
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet= new HashSet<ListNode>();
        ListNode cur=head;
        while(cur!=null){
            if (nodeSet.contains(cur)){
                return cur;
            }else {
                nodeSet.add(cur);
                cur=cur.next;
            }
        }
        return null;
    }
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
      }

}
