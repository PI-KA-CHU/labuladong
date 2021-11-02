package com.labuladong.剑指Offer.链表操作;

import com.labuladong.剑指Offer.Node;

import java.util.HashMap;
import java.util.Map;

public class $剑指Offer_35_复杂链表的复制 {

    /**
     * 拼接与拆分
     * 思路：三遍遍历，第一遍复制每个节点并拼接，第二遍连接random，第三遍拆分
     *
     * 时间：O(n)
     * 空间：O(1)
     *
     * 注意事项：
     * - random指向的可能是null
     */
    public static Node copyRandomList(Node head) {

        Node dummy = new Node(0);
        dummy.next = head;

        Node p1 = dummy;

        while (p1.next != null) {
            Node node = p1.next;
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;

            p1 = newNode;
        }

        p1 = dummy;
        while (p1.next != null) {
            Node node = p1.next;
            //random指向的可能是null
            node.next.random = (node.random == null) ? null : node.random.next;

            p1 = node.next;
        }

        p1 = dummy;
        Node newHead = new Node(0);
        Node p2 = newHead;
        while (p1.next != null) {
            Node node = p1.next;
            p2.next = node.next;
            node.next = node.next.next;

            p2 = p2.next;
            p1 = p1.next;
        }

        return newHead.next;
    }


    /**
     *
     * 利用哈希表存储新旧节点的映射关系
     * 思路：第一遍，存储新旧节点的哈希映射；第二遍，构建next和random指向
     *
     * 时间：O(n)
     * 空间：O(n)
     */
    public static Node copyRandomList1(Node head) {

        Map<Node, Node> map = new HashMap<>();

        Node p1 = head;
        while (p1 != null) {
            map.put(p1, new Node(p1.val));
            p1 = p1.next;
        }

        p1 = head;
        while (p1 != null) {
            map.get(p1).next = map.get(p1.next);
            map.get(p1).random = map.get(p1.random);
            p1 = p1.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.random = head.next.next;
        head.next.next.random = head;

//        copyRandomList(head);
    }
}
