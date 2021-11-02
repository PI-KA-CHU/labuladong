package com.labuladong.剑指Offer.链表操作;

import com.labuladong.剑指Offer.ListNode;

public class 剑指Offer_18_删除链表的节点 {

    /**
     *
     * 注意事项：
     * 1. 建立dummy节点
     * 2. 做遍历的应该是另外的p节点，而不是dummy
     */
    public ListNode deleteNode(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

}
