package com.labuladong.剑指Offer.链表操作;

import com.labuladong.剑指Offer.ListNode;

public class 剑指Offer_25_合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode newHead = new ListNode(0);
        ListNode p3 = newHead;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p3.next = p2;
                p2 = p2.next;
            } else {
                p3.next = p1;
                p1 = p1.next;
            }
            p3 = p3.next;
        }

        p3.next = p1 == null ? p2 : p1;

        return newHead.next;
    }
}
