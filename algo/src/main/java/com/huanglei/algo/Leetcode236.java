package com.huanglei.algo;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Stack;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */

public class Leetcode236 {
    public class Node {
     int val;
     Node left;
     Node right;
     Node(int x) { val = x; }
 }

    Stack<Node> list = new Stack<>();
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        frontTraverse(root,p,q);
        //遍历找到p或q，记录找到的路径
        while(!list.isEmpty()){
            Node candidate = list.pop();
            Node parent = frontTraverse(candidate,p,q);
            if(parent!=null){
                return parent;
            }
        }
        return null;
    }
    public Node frontTraverse(Node root,Node p,Node q){
        if(root==null){
            return null;
        }
        if(root==p||root==q){
            list.push(root);
            return root;
        }
        list.push(root);
        Node target = frontTraverse(root.left,p,q);
        if(target!=null){
            return target;
        }
        list.pop();
        target = frontTraverse(root.right,p,q);
//        if(target!=null){
            return target;
//        }

    }

}
