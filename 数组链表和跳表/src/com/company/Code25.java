package com.company;

public class Code25 {
    /**
     *  这题 是比较典型的题目了，要完成 链表的k 反转，其实只要 每次都把 k范围内的链表反转完毕
     *  然后 将这些链表 头尾相接一下 就算完成了
     *
     *  首先定义 一个dummy 结点，这个dummy 结点 指向 链表的头结点。注意这个dummy的值永远不变，
     *  所以最后要返回 只要返回dummy.next 就可以了
     *
     *  然后再定义一个pre结点，这个pre结点 初始值就是dummy，后续这个pre 值也会改变的。
     *  简单来说 pre 就代表 子链表的前置结点。
     *
     *  循环开始：
     *    循环开始的第一步 其实就是从pre结点开始遍历，遍历到为null 的时候就直接return 就行了 代表后面的结点不足k的大小 不需要反转
     *    否则 我们就 设置一个tail结点，tail结点 永远指向 尾巴
     *    head结点 永远指向 k的head，tail 结点永远指向k的tail
     *
     *    先把 tail.next 的值保存下来 为tmpNext
     *
     *
     *    找到k的head和tail 以后 就直接 反转这个 k大小的链表
     *
     *    翻转之后 head和tail 就都指向新的head和tail了
     *
     *    此时也是最重要的
     *
     *    更新pre.next 为 新的head
     *    更新 tail.next 为tmpNext
     *    更新 pre 为 tail
     *    更新head 为tail.next
     *
     *    其实讲白了  永远要保持 pre 在head的前面，换句话说就是head 永远在pre的后面
     *
     */
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy =new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        while(head!=null){
            ListNode tail=pre;
            for (int i=0;i<k;++i){
                tail=tail.next;
                if (tail==null){
                    return dummy.next;
                }
            }

            ListNode tmpNext=tail.next;

            ListNode[] newResult=reverse(head,tail);

            head=newResult[0];
            tail=newResult[1];

            pre.next=head;
            tail.next=tmpNext;
            pre=tail;
            head=tail.next;

        }

        return dummy.next;


    }

    /**
     *
     * 反转一个链表的 一个部分 head开始 tail结束
     *
     * 定义一个pre结点， 他其实就是tail.next
     *
     * 定义一个cur结点 指向head
     *
     * 循环内部的操作：
     *  1。 先把cur.next 保存下来
     *  2。 让 cur.next 指向pre
     *  3。 pre 等于cur( 这一步其实就是pre++)
     *  4。 cur 等于tmp（这一步其实就是cur++）
     *
     *  循环跳出的条件就是 pre！=tail
     *
     *  因为pre 也会移动，当pre 遍历到tail的时候 就让他结束就行了
     *
     *  返回的时候 注意是tail 在前 head 在后
     *
     *
     *
     *
     */
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode pre=tail.next;
        ListNode cur=head;
        while (pre!=tail){
            ListNode tmp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tmp;
        }
        return new ListNode[] {tail,head};
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
