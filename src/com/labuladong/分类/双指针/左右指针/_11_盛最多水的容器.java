package com.labuladong.分类.双指针.左右指针;

public class _11_盛最多水的容器 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            // 此处注意减法处要加括号
            max = Integer.max(max, Integer.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right --;
            }
        }

        return max;
    }
}
