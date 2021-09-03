package com.huanglei.algo;


/**
 * 合并k个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *  1->4->5,
 *  1->3->4,
 *  2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Leetcode23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeKLists2Elements(lists, 0, lists.length - 1);

    }

    public ListNode mergeKLists2Elements(ListNode[] lists, int start, int end) {
        if (end - start > 1) {
            ListNode ln1 = mergeKLists2Elements(lists, start, start + ((end - start) / 2));
            ListNode ln2 = mergeKLists2Elements(lists, start + ((end - start) / 2) + 1, end);
            return doMerge(ln1, ln2);
        }
        if (end == start) {
            return lists[start];
        }
        return doMerge(lists[start], lists[end]);
    }

    public ListNode doMerge(ListNode node1, ListNode node2) {
        //亚元素
        ListNode resultListNode = new ListNode(0);
        ListNode lastNode = resultListNode;
        ListNode nextNode = null;
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                nextNode = node2;
                node2 = node2.next;
            } else if (node2 == null || node1.val < node2.val) {
                nextNode = node1;
                node1 = node1.next;
            } else {
                nextNode = node2;
                node2 = node2.next;
            }
            lastNode.next = nextNode;
            lastNode = nextNode;
        }
        return resultListNode.next;
    }

    public static void main(String[] args) {


//        ListNode ln = new Leetcode23().mergeKLists(3);
//
//        while (ln.next != null) {
//            System.out.print(ln.next.val + "-->");
//        }
    }
}
