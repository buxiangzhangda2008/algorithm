package com.huanglei.algo;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(){

    }
    @Override
    public String toString(){
        return val+"";
    }
    /**
     *               1
                   /   \
                  2     3 
                /   \  / \
               4   5  6  7 
             /   \  /
             8   9 10 
     */
    public static TreeNode buildTree(){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node10.left = node11;

        return node1;
    }

    public static TreeNode buildNode(int val) {
        return new TreeNode(val);
    }
}
