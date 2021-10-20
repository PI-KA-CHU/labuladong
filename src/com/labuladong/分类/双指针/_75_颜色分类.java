package com.labuladong.分类.双指针;

public class _75_颜色分类 {


    /**
     * 推荐（双指针太容易出错）
     *  单指针
     * 思路：两次遍历，第一次遍历把0往前面置换，第二次遍历把1往前置换
     * 时间：O(n)
     * 空间：O(1)
     *
     */
    public void sortColors0(int[] nums) {

        int p = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p);
                p ++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p);
                p++;
            }
        }

    }


    /**
     * 双指针
     * 思路：左右指针，分别用于置换0，2
     *
     * 注意事项：
     * - 需要先循环置换2，再置换0，否则0可能丢失
     * - 置换2需要用while，否则置换的可能本来就是2，i继续走导致2丢失
     * - while中需要用i <= p2，否则{2}会造成下标溢出
     *
     */
    public void sortColors(int[] nums) {

        int p0 = 0;
        int p2 = nums.length - 1;

        for (int i = 0; i <= p2; i++) {

            // 因为换出来的值可能仍然是2，不用while会导致2丢失
            // i <= p2需要控制结束条件，否则会把已经置换的2又置换出来
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2);
                p2 --;
            }

            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0 ++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
