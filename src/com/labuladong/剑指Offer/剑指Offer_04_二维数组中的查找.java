package com.labuladong.剑指Offer;

import javax.sound.sampled.Line;

public class 剑指Offer_04_二维数组中的查找 {

    /**
     *
     * 注意事项：
     * - 错误方向：二分
     * - col、row范围
     * - 二维数组判空处理（背诵并形成框架）
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row <= matrix.length - 1 && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }

            if (target < matrix[row][col]) {
                col--;
            } else {
                row ++;
            }
        }

        return false;
    }

}
