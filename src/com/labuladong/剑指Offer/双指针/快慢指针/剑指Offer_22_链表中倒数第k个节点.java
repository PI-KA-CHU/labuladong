package com.labuladong.剑指Offer.双指针.快慢指针;

import com.labuladong.剑指Offer.ListNode;

public class 剑指Offer_22_链表中倒数第k个节点 {

    /**
     * 思路：
     *  对于k从1开始计数的情况，先走k>=1个节点，最后求得的就是倒数第k个几点
     *
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k >= 1 && fast != null) {
            fast = fast.next;
            k --;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
