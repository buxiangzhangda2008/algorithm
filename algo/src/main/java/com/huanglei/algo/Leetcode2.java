package com.huanglei.algo;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Leetcode2 {


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode l3 = addTwoNumbers(l1, l2);
        print(l3);
    }

    public static void print(ListNode l) {
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = l1;
        ListNode ret = l1;
        int pos = 0;
        while (l1 != null && l2 != null) {
            l1.val = l1.val + l2.val + pos;
            pos = l1.val / 10;
            l1.val = l1.val >= 10 ? l1.val - 10 : l1.val;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;

        }
        if (l1 == null) {
            l1 = l2;
            pre.next = l1;
        }
        while (l1 != null) {
            l1.val = l1.val + pos;
            pos = l1.val / 10;
            if (l1.val >= 10) {
                l1.val = l1.val - 10;
            } else {
                break;
            }
            pre = l1;
            l1 = l1.next;
        }

        if (pos > 0) {
            pre.next = new ListNode(1);
        }
        return ret;
    }
    public static ListNode addList(ListNode l1,ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
