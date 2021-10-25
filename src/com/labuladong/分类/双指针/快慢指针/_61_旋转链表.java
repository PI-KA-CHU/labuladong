package com.labuladong.分类.双指针.快慢指针;

import com.labuladong.剑指Offer.ListNode;

public class _61_旋转链表 {


    /**
     * 快慢指针（推荐）
     * 思路：
     *  可以利用求倒数第k个节点的快慢指针框架，将while中的fast != null改为fast.next != null。
     *  这样到达的就是目标节点的前一个节点，再进行操作。
     *
     * 注意事项：
     *  - 到达后需要先操作fast指针指向head，再操作其他的（为了满足k==0的情况）
     *
     */
    public ListNode rotateRight0(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        int len = 0;
        while (fast != null) {
            fast = fast.next;
            len ++;
        }
        k = k % len;

        fast = head;
        while (k >= 1) {
            fast = fast.next;
            k --;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //需要先设置fast指向head，否则对于k = 0的情况，也就是不移动的情况会有问题
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;

        return newHead;
    }


    public ListNode rotateRight(ListNode head, int k) {
        // 记住这个链表判空
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode iter = head;
        int len = 1;

        // 因为由iter.next不为空判断，len从1开始，此处是为了方便iter停在链表尾部
        while (iter.next != null) {
            len ++;
            iter = iter.next;
        }

        k = k % len;
        //右移两位，我们需要在它的前一位停下
        int n = len - k - 1;
        ListNode prt = head;

        while (n > 0) {
            prt = prt.next;
            n --;
        }

        iter.next = head;
        head = prt.next;
        prt.next = null;

        return head;
    }

    public static void main(String[] args) {
        System.out.println(1 % 2);
    }
}

