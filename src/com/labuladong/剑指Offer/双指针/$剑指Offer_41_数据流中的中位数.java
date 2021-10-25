package com.labuladong.剑指Offer.双指针;

import java.util.*;


public class $剑指Offer_41_数据流中的中位数 {

    /**
     * 思路：大顶堆和小顶堆，大顶堆存放小的一半数据，小顶堆存放大大一半数据，则
     *      - A.size == B.size - 两个堆顶为平均值为中位数值
     *      - A.size != B.size - A堆顶为中位数值
     *
     * 时间：O(logn)
     * 空间：O(n)
     */
    Queue<Integer> qA;
    Queue<Integer> qB;
    public $剑指Offer_41_数据流中的中位数() {
        //小顶堆
        qA = new PriorityQueue<>();
        //大顶堆
        qB = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        if (qA.size() == qB.size()) {
            qB.add(num);
            qA.add(qB.poll());
        } else {
            qA.add(num);
            qB.add(qA.poll());
        }
    }

    public double findMedian() {
        if (qA.size() == qB.size()) {
            return qA.size() == 0 ? -1 : (qA.peek() + qB.peek()) / 2.0;
        } else {
            return qA.peek();
        }
    }

    public static void main(String[] args) {
        System.out.println(0 % 2);
    }
}
