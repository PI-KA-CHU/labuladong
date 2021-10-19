package com.labuladong.剑指Offer.双指针;

import com.labuladong.剑指Offer.ListNode;

public class 剑指Offer_24_反转链表 {

    /**
     *
     * 重点：
     * - pre、curr、next指针，next是暂存的指针
     *
     */
    public ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }

}
