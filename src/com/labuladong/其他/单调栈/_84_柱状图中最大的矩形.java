package com.labuladong.其他.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _84_柱状图中最大的矩形 {


    /**
     * 单调栈
     *
     * 时间：O(n)
     * 空间：O(n)
     *
     * 注意事项：
     * - 正序遍历
     * - 填充右边界（哨兵）
     */
    public int largestRectangleArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();

        int n = heights.length;
        //存储右边界（right[i]表示下标为i的元素的右边第一个小于该元素的元素下标）
        int[] right = new int[n];
        //存储左边界
        int[] left = new int[n];

        //需要为其设置有边界（哨兵），防止都是递增的情况下，没有右边界，如果右有边界，则自然会被更新
        Arrays.fill(right, n);

        for (int i = 0; i < n; i++) {
            //此处虽然等于时也会出栈，但是保证了相同的相邻元素中至少了有一个能正常计算，即最后一个
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                //当前元素小于栈顶，即栈顶第一次遇到小于自己的右边界
                right[stack.peek()] = i;
                stack.pop();
            }
            //把比当前元素大的值都抛出，栈顶即为当前元素左边界（第一个小于自己的）
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Integer.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }
}
