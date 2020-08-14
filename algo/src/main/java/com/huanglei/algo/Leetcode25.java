package com.huanglei.algo;


/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 */
public class Leetcode25 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        return null;
    }

    public ListNode swapKNodes(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int K = k;
        ListNode currHead = head;
        ListNode node = currHead;
        ListNode node1Pre = null;
        while (K-- > 0 && node != null) {
            ListNode node1 = currHead;
            ListNode node2Pre = node;
            ListNode node2 = node.next;
            if (node2 == null) {
                return head;
            }
            ListNode node_ = swap(node1Pre, node1, node2Pre, node2);
            if (K == 0) {
                node1Pre = node2;
                K = k;
                currHead = node2.next;
            }
            node = node.next;
        }

        return head;
    }


    public ListNode swap(ListNode node1Pre, ListNode node1, ListNode node2Pre, ListNode node2) {

        if (node1 == null || node2 == null)
            return node1;
        ListNode node1Next = node1.next;
        ListNode node2Next = node2.next;
        if (node1Pre != null) {
            node1Pre.next = node2;
        }
        if (node2 != node1Next) {
            node2.next = node1.next;
            node2Pre.next = node1;
        } else {
            node2.next = node1;
        }
        node1.next = node2Next;
        return node2;
    }


    public static void main(String[] args) {


        Leetcode25.ListNode ln1 = new Leetcode25.ListNode(1);
        Leetcode25.ListNode ln2 = new Leetcode25.ListNode(2);
        Leetcode25.ListNode ln3 = new Leetcode25.ListNode(3);
        Leetcode25.ListNode ln4 = new Leetcode25.ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        Leetcode25.ListNode listNode = new Leetcode25().swapKNodes(ln1, 2);


        while (listNode != null) {
            System.out.print(listNode.val + "-->");
            listNode = listNode.next;
        }
    }
}


