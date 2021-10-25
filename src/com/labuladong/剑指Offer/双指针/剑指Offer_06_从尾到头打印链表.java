package com.labuladong.剑指Offer.双指针;

import com.labuladong.剑指Offer.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 剑指Offer_06_从尾到头打印链表 {

    /**
     * 如果是倒序输出的，可以考虑利用栈
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public int[] reversePrint0(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int i = 0;
        int[] nums = new int[stack.size()];
        while (!stack.isEmpty()) {
            nums[i++] = stack.pop();
        }

        return nums;

    }

    public int[] reversePrint(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] nums = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            nums[i] = Integer.parseInt(list.get(list.size() - 1 - i) + "");
        }
        return nums;
    }
}
