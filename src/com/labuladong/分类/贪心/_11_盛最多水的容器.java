package com.labuladong.分类.贪心;

public class _11_盛最多水的容器 {

    /**
     * 贪心（双指针）
     *  思路：左右指针指向数组左右两侧，计算面积，并将指向高度小的指针移动
     *
     */
    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = Integer.min(height[left], height[right]) * (right - left);
            maxArea = Integer.max(area, maxArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
