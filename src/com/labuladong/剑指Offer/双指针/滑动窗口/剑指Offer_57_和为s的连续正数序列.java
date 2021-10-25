package com.labuladong.剑指Offer.双指针.滑动窗口;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer_57_和为s的连续正数序列 {

    /**
     * 双指针：滑动窗口
     *
     * 时间：O(n)
     * 空间：O(1)：除了答案数组外需要额外的O(1)空间存储
     *
     * 注意事项：
     * - 等差数列和：n(a1 + an)/2
     */
    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;

        List<int[]> ans = new ArrayList<>();

        while (left < right) {
            int sum = (right - left + 1) * (left + right) / 2;
            if (target == sum) {
                int[] subAns = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    subAns[i - left] = i;
                }
                ans.add(subAns);
                left++;
            } else if (sum < target) {
                right++;
            } else {
                left++;
            }
        }

//        int[][] ansArr = ans.stream()
//                .map(list -> list.stream().mapToInt(Integer::intValue).toArray())
//                .toArray(int[][]::new);
        return ans.toArray(new int[ans.size()][]);
    }


    public int[][] findContinuousSequence1(int target) {
        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> ans = new ArrayList<>();

        while (right <= target) {
            if (sum < target) {
                sum += right;
                right ++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {

            }

            if (sum == target) {
                int[] subAns = new int[right - left];
                for (int i = left; i < right; i++) {
                    subAns[i - left] = i;
                }
                ans.add(subAns);

                sum -= left;
                left ++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] findContinuousSequence2(int target) {

        int left = 1;
        int right = 1;
        int sum = 0;
        List<int[]> ans = new ArrayList<>();

        while (right <= target) {
            if (sum == target) {
                int[] subAns = new int[right - left];
                for (int i = left; i < right; i++) {
                    subAns[i - left] = i;
                }
                ans.add(subAns);

                sum -= left;
                left ++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                sum += right;
                right++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(2);
        ans.add(1);

        ans.remove(1);

        System.out.println(ans);
    }
}
