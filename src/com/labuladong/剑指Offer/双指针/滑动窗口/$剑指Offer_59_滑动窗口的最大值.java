package com.labuladong.剑指Offer.双指针.滑动窗口;

import java.util.*;

public class $剑指Offer_59_滑动窗口的最大值 {


    /**
     * 单调队列
     * 思路：维护一个单调队列（存放元素下标），当right向右移动时，
     *      将right对应当元素与队列尾部的元素大小做比较，若队列尾部元素比当前元素小，则出队（因为该元素不可能为最大值）
     *      如果窗口大小大于k，则说明左边需要收缩，队列头部下标小于left的，都需要剔除
     *
     * 时间：O(n)
     * 空间：O(k)
     *
     * 注意事项：
     * - 队列存放的是下标
     * - 本题本质仍是滑动窗口，不过对获取窗口的对大值上采用了单调队列优化
     *
     */
    public static int[] maxSlidingWindow0(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Deque<Integer> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < nums.length) {

            int num = nums[right];
            right++;

            // 1.右移需要更新的数据
            while (!queue.isEmpty() && nums[queue.peekLast()] < num) {
                queue.pollLast();
            }
            queue.offer(right - 1);

            // 2.什么时候需要缩小窗口
            while (right - left > k) {
                left ++;
                // 3.缩小窗口后需要更新的数据
                while (!queue.isEmpty() && queue.peekFirst() < left) {
                    queue.pollFirst();
                }
            }

            // 4.要求的结果是在窗口扩大后更新还是在缩小后更新（此处是缩小后）
            if (right - left == k && !queue.isEmpty()) {
                ans.add(nums[queue.peekFirst()]);
            }

        }


        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 优先队列
     *
     * 时间：O(nlogn)
     * 空间：O(n)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((int[] x, int[] y) -> (y[0] - x[0]));

        int left = 0;
        int right = k;

        for (int i = left; i < k; i++) {
            queue.add(new int[]{nums[i], i});
        }

        ans.add(queue.peek()[0]);

        while (right < nums.length) {
            queue.offer(new int[]{nums[right], right});
            right ++;
            left ++;

            while (true) {
                assert queue.peek() != null;
                if (!(queue.peek()[1] < left)) break;
                queue.poll();
            }

            ans.add(queue.peek()[0]);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        int k = 1;

        System.out.println(maxSlidingWindow(nums, k));
    }

}
