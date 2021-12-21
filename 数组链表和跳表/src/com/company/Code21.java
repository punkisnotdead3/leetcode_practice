package com.company;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Code21 {
    /**
     *
     *  这道题 其实很简单， 主要是要想办法 把最终的链表的头结点返回回去
     *
     *  我们可以定义一个 prevhead结点，这个结点 就是 一个 毫无意义的结点
     *
     *  然后定义一个prevNode结点 这个结点的值 一开始等于prevHead的值
     *
     *  实际上 一开始 prevHead 与 prevNode 都指向 一个毫无意义的ListNode节点。
     *
     *  当循环开始的时候 这个ListNode节点 的next 就会指向 list1 或者是list2的 第一个结点了
     *
     *  当循环结束的时候 不要忘记 拼接剩下的节点。
     *
     *  最后就是当循环结束的时候 prevNode 显然不会在链表的头部
     *
     *  但是我们的prevHead 依然在第一个结点的前面
     *
     *  所以只要返回prevHead.next 就可以了
     *
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prevHead = new ListNode(-1);
        ListNode prevNode = prevHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prevNode.next = list1;
                list1 = list1.next;
            } else {
                prevNode.next = list2;
                list2 = list2.next;
            }
            prevNode = prevNode.next;
        }

        if (list1 != null) {
            prevNode.next = list1;
        }
        if (list2 != null) {
            prevNode.next = list2;
        }
        return prevHead.next;

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
