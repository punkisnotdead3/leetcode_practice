package com.company;

public class Code24 {
    /**
     *  这题的精髓 也是在于  定义一个prev节点，他始终指向的是 链表的头结点
     *
     *  然后 再定义个 一个 p 结点，整个结点 一开始就和p一样，指向 头结点
     *
     *  然后随着 循环的进行 最后 他会停留在链表的尾部
     *
     *  此外要注意的是 循环体内部怎么写的技巧
     *
     *  其实只要注意1点。 因为 一开始 a和 b  是a 在前 b 在后，
     *  调换位置以后 是 b 在前 a在后。
     *
     *  所以最后一步  一定是 p结点 指向a结点。
     *
     *
     *
     */
    public ListNode swapPairs(ListNode head) {
        ListNode prev= new ListNode(-1);
        prev.next=head;
        ListNode p=prev;
        while (p.next !=null&&p.next.next!=null){
            ListNode a=p.next;
            ListNode b=p.next.next;
            p.next=b;
            a.next=b.next;
            b.next=a;
            p=a;
        }
        return prev.next;



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
