package com.huanglei.algo;

import java.util.*;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */

//使用双指针，两个指针间距为n，当第1个指针走到末尾时，第二个指针就是目标对象；
public class Leetcode19 {

    //    Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode h = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int length = 0;
        while (h != null) {
            map.put(length++, h);
            h = h.next;
        }
        int target = length - n;
        ListNode t = map.get(target);
        if (target - 1 >= 0) {
            ListNode pre = map.get(target - 1);
            pre.next = t.next;
        } else {
            return head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Leetcode19 lc = new Leetcode19();
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            curr.next = node;
            curr = node;
        }

        ListNode listNode = lc.removeNthFromEnd(head, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
