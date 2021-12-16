package com.company;

public class Code141 {
    /**
     *  快慢指针 解法
     *
     *  如果链表有环的话，一定会在某个时刻相遇的
     *
     *
     *
     *
     */
    public boolean hasCycle(ListNode head) {
        // 防止空指针异常
        if (head==null||head.next==null){
            return false;
        }
        // 一开始快指针 就要比 慢指针 快出一个身位
        ListNode slow=head;
        ListNode quick=head.next;
        // 快慢指针 相等的时候 就跳出去 代表链表有环了
        while (slow!=quick){
            // 先判断是不是为null 如果为null 意味着必定没有环
            if (quick==null||quick.next==null)
            {
                return  false;
            }
            slow=slow.next;
            quick=quick.next.next;


        }
        return true;
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