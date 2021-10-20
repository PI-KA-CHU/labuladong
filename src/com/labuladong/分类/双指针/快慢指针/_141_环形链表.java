package com.labuladong.分类.双指针.快慢指针;

import com.labuladong.剑指Offer.ListNode;

public class _141_环形链表 {

    /**
     * 双指针（快慢指针）
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
