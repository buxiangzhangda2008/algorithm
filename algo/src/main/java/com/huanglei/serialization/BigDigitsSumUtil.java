package com.huanglei.serialization;

import com.huanglei.algo.ListNode;

public class BigDigitsSumUtil {
    public static void main(String[] args) {
        System.out.println("BigDigitsSum");
        ListNode ln1 = new ListNode(2);
        ln1.next = new ListNode(4);
        ln1.next.next = new ListNode(3);

        ListNode ln2 = new ListNode(5);
        ln2.next = new ListNode(6);
        ln2.next.next = new ListNode(4);

        new BigDigitsSumUtil().add(ln1, ln2);
    }

    public void add(ListNode ln1, ListNode ln2) {
        int forward = 0;
        ListNode ln3 = new ListNode();
        ListNode headDummy = ln3;
        while (ln1 != null || ln2 != null) {
            ListNode next = new ListNode();
            int a = 0;
            int b = 0;
            if (ln1 != null) {
                a = ln1.val;
                ln1 = ln1.next;
            }
            if (ln2 != null) {
                b = ln2.val;
                ln2 = ln2.next;
            }
            int sum = a + b + forward;
            forward = sum / 10;
            next.val = sum % 10;
            ln3.next = next;
            ln3 = next;

        }
        if (forward > 0) {
            ListNode ln = new ListNode();
            ln.val = 1;
            ln3.next = ln;
        }
        while (headDummy != null) {
            headDummy = headDummy.next;
            if (headDummy != null)
                System.out.print(headDummy.val + "->");
        }
    }
}
