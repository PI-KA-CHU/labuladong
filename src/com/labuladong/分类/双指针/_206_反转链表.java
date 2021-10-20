package com.labuladong.分类.双指针;

import com.labuladong.剑指Offer.ListNode;

public class _206_反转链表 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

}
