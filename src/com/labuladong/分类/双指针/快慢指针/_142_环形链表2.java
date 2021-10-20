package com.labuladong.分类.双指针.快慢指针;

import com.labuladong.剑指Offer.ListNode;

public class _142_环形链表2 {

    /**
     * 双指针（快慢指针）
     * 思路：当快慢指针相遇时，pre指向head，跟slow同时前进，它们相遇时即为交点
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null) {
                break;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }
}
