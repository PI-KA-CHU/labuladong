package com.labuladong.其他.单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _85_最大矩形 {

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[] heights = new int[matrix[0].length];
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            ans = Integer.max(ans, maxArea(heights));
        }

        return ans;

    }

    public int maxArea(int[] heights) {

        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Integer.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }

        return ans;
    }

}
