package com.huanglei.algo;

public class ListFoldHalf {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node9 = new Node();
        Node node10 = new Node();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node6.val = 6;
        node7.val = 7;
        node8.val = 8;
        node9.val = 9;
        node10.val = 10;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = null;
//        Node reverseList = new ListFoldHalf().reverse(node1);
//        while(reverseList!=null){
//            System.out.println(reverseList.val);
//            reverseList = reverseList.next;
//        }
        Node node = new ListFoldHalf().foldHalf(node1, 10);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public Node reverse(Node node){
        Node head = node;
        Node pre = node;
        node = node.next;
        while(node!=null){
          pre.next = node.next;
          node.next = head;
          head = node;

          node = pre.next;
        }
        return head;
    }
    public Node foldHalf(Node root, int n) {
        //1, traval to the mid
        int target = (n + 1) / 2;
        Node left = root;
        while (--target > 0) {
            root = root.next;
        }
        Node right = root.next;
        root.next = null;
        //2, reverse the half
        right = reverseList(right);
        //3, merge the two list one by one
        return mergeOneByOne(left, right);
    }

    public Node reverseList(Node list) {
        Node head = list;
        Node pre = head;
        Node pos = pre.next;
        while (pos != null) {
            pre.next = pos.next;
            pos.next = head;
            head = pos;
            pos = pre.next;
        }
        return head;
    }

    private Node mergeOneByOne(Node left, Node right) {
        Node head = left;
        while (left != null && right != null) {
            Node rightNext = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = rightNext;
//            Node leftNext = left.next;
//            Node rightNext = right.next;
//            left.next = right;
//            right.next = leftNext;
//            left = leftNext;
//            right = rightNext;
        }
        return head;
    }

    static class Node {
        Node next;
        int val;
    }

}
