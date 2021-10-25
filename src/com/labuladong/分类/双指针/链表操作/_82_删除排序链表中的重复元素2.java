package com.labuladong.分类.双指针.链表操作;

import com.labuladong.剑指Offer.ListNode;

public class _82_删除排序链表中的重复元素2 {

    /**
     *
     * 时间：O(n)
     * 空间：O(1)
     *
     * 注意事项：创建dummy哑节点，记住消除所有重复值的模版
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;

        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int x = curr.next.val;
                while (curr.next != null && curr.next.val == x) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
