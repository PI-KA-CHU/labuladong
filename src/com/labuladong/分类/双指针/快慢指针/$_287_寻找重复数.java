package com.labuladong.分类.双指针.快慢指针;

public class $_287_寻找重复数 {

    /**
     * 双指针（快慢指针）
     * 思路：将下标与所在的值（作为下标）连接为边，对于有重复数字的数组，可以得到有环的结构，根据快慢指针可以找到循环点
     *
     * 时间：O(n)
     * 空间：O(1)
     */
    public static int findDuplicate(int[] nums) {

        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int prt = 0;
        while (prt != slow) {
            prt = nums[prt];
            slow = nums[slow];
        }

        return prt;
    }


    public static void main(String[] args) {
        int[] nums = {1,1};
        findDuplicate(nums);
    }
    
}
