package com.huanglei.algo;


/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Leetcode24 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode node = head;

        if (node == null || node.next == null) {
            return node;
        } else {
            ListNode nodeNext = node.next;
            ListNode nodeNextNext = nodeNext.next;
            nodeNext.next = node;
            node.next = nodeNextNext;
            head = nodeNext;
        }
        ListNode pre = head.next;
        while (pre != null) {
            doSwap(pre, pre.next);
            if (pre.next != null) {
                pre = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }


    public void doSwap(ListNode pre, ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        ListNode nodeNext = node.next;
        ListNode nodeNextNext = nodeNext.next;
        pre.next = nodeNext;
        nodeNext.next = node;
        node.next = nodeNextNext;
    }

    public static void main(String[] args) {


        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        ListNode listNode = new Leetcode24().swapPairs(ln1);


        while (listNode != null) {
            System.out.print(listNode.val + "-->");
            listNode = listNode.next;
        }
    }
}
