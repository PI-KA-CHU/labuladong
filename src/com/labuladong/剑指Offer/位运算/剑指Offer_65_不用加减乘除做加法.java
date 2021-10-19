package com.labuladong.剑指Offer.位运算;

public class 剑指Offer_65_不用加减乘除做加法 {

    /**
     * 位运算
     * - 非进位运算：a ^ b
     * - 进位运算：(a & b) << 1
     * - 原数 = 非进位 + 进位（所以循环直到进位为0）
     *
     * https://blog.csdn.net/zhongjiekangping/article/details/6855864
     */
    public int add(int a, int b) {

        int c1 = 0;
        int c2 = 0;

        //没有进位了，则为所求
        while (b != 0) {
            c1 = a ^ b; // 非进位和
            c2 = (a & b) << 1;  //进位和

            //非进位和 + 进位和即为结果，但是不能用加法，所以继续
            a = c1;
            b = c2;
        }

        return a;
    }

}
