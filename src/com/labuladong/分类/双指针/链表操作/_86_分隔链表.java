package com.labuladong.分类.双指针.链表操作;

import com.labuladong.剑指Offer.ListNode;

public class _86_分隔链表 {

    /**
     * 多指针操作
     *
     * 思路：分别保留两对链表的头尾指针，
     * 时间：O(n)
     * 空间：O(1)
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode smallHead = new ListNode(0);
        ListNode largeHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode large = largeHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                small.next = curr;
                small = small.next;
            } else {
                large.next = curr;
                large = large.next;
            }
            curr = curr.next;
        }

        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}
