package com.huanglei.algo;

import java.util.List;
import java.util.Stack;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Leetcode21 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        ListNode resultList = currL1;
        if (currL1.val >= currL2.val) {
            resultList = l2;
            currL2 = currL2.next;
        } else {
            resultList = l1;
            currL1 = currL1.next;
        }
        ListNode currResult = resultList;
        while (currL1 != null && currL2 != null) {
            if (currL1.val <= currL2.val) {
                currResult.next = currL1;
                currL1 = currL1.next;
            } else {
                currResult.next = currL2;
                currL2 = currL2.next;
            }
            currResult = currResult.next;
        }
        if (currL1 == null) {
            currResult.next = currL2;
        }
        if (currL2 == null) {
            currResult.next = currL1;
        }
        return resultList;
    }

    public static void main(String[] args) {
        Leetcode21 lc = new Leetcode21();
        ListNode head1 = new Leetcode21.ListNode(1);
//        Leetcode21.ListNode curr = head1;
//        for (int i = 2; i <= 5; i++) {
//        Leetcode21.ListNode node = new Leetcode21.ListNode(2);
//        head1.next = node;
//        Leetcode21.ListNode node1 = new Leetcode21.ListNode(4);
//        node.next = node1;
//        curr = node;
//        }
        ListNode head2 = new Leetcode21.ListNode(2);
//        Leetcode21.ListNode curr2 = head2;
//        for (int i = 3; i <= 6; i++) {
//        Leetcode21.ListNode node11 = new Leetcode21.ListNode(3);
//        head2.next = node11;
//        Leetcode21.ListNode node12 = new Leetcode21.ListNode(4);
//        node11.next = node12;
//            curr2 = node;
//        }

        Leetcode21.ListNode listNode = lc.mergeTwoLists(head1, head2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
