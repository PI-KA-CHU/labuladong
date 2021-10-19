package com.labuladong.剑指Offer.二分查找;

public class 剑指Offer_11_旋转数组的最小数字 {

    /**
     *
     * 字节一面面试题
     *
     * 注意事项：
     * - right在移动时，不能mid - 1，因为该mid值可能为所求
     *
     */
    public int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            // low+high在low和high特别大的时候可能会造成溢出
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 此处不能 - 1，因为可能该最小值就是所求
                right = mid;
            } else {
                right --;
            }
        }

        return numbers[left];
    }

}
