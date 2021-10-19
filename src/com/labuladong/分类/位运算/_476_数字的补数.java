package com.labuladong.分类.位运算;

public class _476_数字的补数 {

    public int findComplement(int num) {

        int height = -1;
        for (int i = 31; i >= 0; i--) {
            if (((num >> i) & 1) != 0) {
                height = i;
                break;
            }
        }

        int ans = 0;
        for (int i = 0; i <= height; i++) {
            if (((num >> i) & 1) == 0) {
                // 把每个0的位取反并保存，（1 << i）得到第i位为1，其他位为0的数
                ans |= (1 << i);
            }
        }
        return ans;
    }

}
