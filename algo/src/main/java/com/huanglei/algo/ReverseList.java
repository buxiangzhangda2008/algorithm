package com.huanglei.algo;

public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        ListNode node9 = new ListNode(9);
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node11;
//        ListNode ret = reverseKList(node1, 3);
        ListNode ret = reverseKList(node1, 5);

        while (ret != null) {
            System.out.print(ret.value + "->");
            ret = ret.next;
        }

    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * 一个单链表从表结尾开始每个k个元素进行反转
     * 例如：0->1->2->3->4>5->6->7,k=3,
     * 反转后，
     * 0->1->4->3->2->7->6->5
     *
     * @param root
     * @return
     */
    public static ListNode reverseKList(ListNode root, int k) {
        if (root == null) {
            return null;
        }
        ListNode node = reverseList(root);
        ListNode i = node, j = node;
        int step = k;
        while (step > 1 && j.next!=null) {
            j = j.next;
            step--;
        }
        if (step > 1) {
            return reverseList(node);
        }
        ListNode topi = i, topj = j;
        if(topj.next==null){
            return topi;
        }
        step = k;
        i = j = topj.next;

        while (step > 1 && j.next!=null) {
            j = j.next;
            step--;
        }
        if (step > 1) {
            i = reverseList(i);
        }
        step = 1;
        ListNode curri = i, currj = j;
        while (step == 1) {
            topj.next = currj.next;
            currj.next = topi;
            topi = curri;
            step = k;
            curri = currj = topj.next;
            while (step > 1 &&currj.next != null) {
                currj = currj.next;
                step--;
            }
        }
        if (step > 1) {
            currj = curri;
            curri = reverseList(curri);
            topj.next = currj.next;
            currj.next = topi;
            topi = curri;
        }

        return topi;
    }

    public static ListNode reverseList(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode top = node;
        ListNode tail = top;
        ListNode curr = top.next;
        while (curr != null) {
            tail.next = curr.next;
            curr.next = top;
            top = curr;
            curr = tail.next;
        }
        return top;
    }
}
