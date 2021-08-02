package com.huanglei.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgoPractice {

    public static Node addVal(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return null;
        }
        Node head = new Node(0);
        Node pre = head;
        int add = 0;
	System.out.println("hello,world");
        while(n1!=null && n2!=null) {
            if (n1 == null) {
                n1 = new Node(0);
            }
            if (n2 == null) {
                n2 = new Node(0);
            }
            int curVal = n1.val + n2.val+add;
            pre.next = new Node(curVal%10);
            pre = pre.next;
            n1 = n1.next;
            n2 = n2.next;
            add = curVal/10;
        }
        if (add == 1) {
            pre.next = new Node(1);
        }

        return head.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        Node n2 = new Node(1);
        n2.next = new Node(2);
	Node n3 = new Node(3);
        Node ret = addVal(n1,n2);
        String s = "";
        while(ret !=null) {
            s+= ret.val;
            ret = ret.next;
        }
        System.out.println(s);
    }



static class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}



}
