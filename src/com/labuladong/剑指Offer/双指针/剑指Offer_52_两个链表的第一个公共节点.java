package com.labuladong.剑指Offer.双指针;

import com.labuladong.剑指Offer.ListNode;

public class 剑指Offer_52_两个链表的第一个公共节点 {


    /**
     *
     * 时间：O(n)
     * 空间：O(1)
     *
     * 注意事项：
     * - 对于没有交点的链表，其最终停在pA = pB = null上
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            pA = pA == null ? headA : pA.next;
            pB = pB == null ? headB : pB.next;
        }

        return pA;
    }
}
