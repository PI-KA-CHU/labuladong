package com.labuladong.剑指Offer;

import javax.xml.bind.annotation.XmlID;

public class 剑指Offer_069_山峰数组的顶部 {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else if (arr[mid] < arr[mid - 1]) {
                right = mid;
            }
        }

        return -1;
    }
}
