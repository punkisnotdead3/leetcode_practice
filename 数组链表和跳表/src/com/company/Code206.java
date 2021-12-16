package com.company;

public class Code206 {
    /**
     *
     *  核心思想：
     *  2个指针，一个while循环，循环里面 分四步， 定义tmp， 交换 cur cur.next pre的值 即可
     *
     *  算法解释：
     *
     *  定义一个pre 指针 他一开始是个null
     *
     *  定义一个cur指针 他的值等于head的值 都是指向链表的头结点
     *
     *  开始循环：
     *
     *  cur为null 肯定就退出了 这个很好理解
     *
     *  每次先把cur结点的next 存储到一个tmp 指针中。 这是为了后面 把tmp指针 赋值给cur 免的 cur 循环不下去
     *
     *  把pre结点的值 赋值 给 cur.next，此时实际上cur结点就已经和cur后面的结点 连接断掉了
     *
     *  将pre指针 赋值 为 cur，
     *
     *  最后将cur 指向tmp
     *
     *
     *  假设一个链表的顺序是 A(1)-B(2)-C(3)-D(4)-E(5)
     *
     *  一开始 pre指向null
     *  cur的值是head 也就是指向 A 结点
     *
     *  第一次循环结束以后：
     *  A这个结点的next指针 指向了 pre指针 也就是null
     *  Pre这个指针指向A了
     *  Cur 指向 B结点了
     *
     *  Pre->A(1)->null
     *  B(2)-C(3)-D(4)-E(5)
     *
     *  第二次循环结束以后：
     *  *  B这个结点的next指针 指向了 A(1) 也就是null
     *  *  Pre这个指针指向B了
     *  *  Cur 指向 C结点了
     *
     *  以此类推
     *
     *
     *
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode tmp=cur.next;
            cur.next= pre;
            pre=cur;
            cur=tmp;
        }
        return pre;
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}