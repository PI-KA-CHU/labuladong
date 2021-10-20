package com.labuladong.分类.双指针;

import com.labuladong.剑指Offer.ListNode;

public class _160_相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {

            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;
        }

        return pA;
    }
}
