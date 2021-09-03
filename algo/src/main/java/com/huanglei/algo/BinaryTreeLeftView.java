package com.huanglei.algo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftView {
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
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        System.out.println(new BinaryTreeLeftView().getLeftView(node1));
    }
    public List<Node> getLeftView(Node root){
        List<Node> leftView = new ArrayList<>();
        List<Node> currLevel = new ArrayList<>();
        currLevel.add(root);
        while(!currLevel.isEmpty()){
            leftView.add(currLevel.get(0));
            currLevel = getNextLevel(currLevel);
        }
        return leftView;
    }
    private List<Node> getNextLevel(List<Node> level){
        List<Node> nextLevel = new ArrayList<>();
        for(Node node:level){
            if(node.left!=null){
                nextLevel.add(node.left);
            }
            if(node.right!=null){
                nextLevel.add(node.right);
            }
        }
        return nextLevel;
    }

    static class Node {
        Node left;
        Node right;
        int val;
        @Override
        public String toString(){
            return val+"";
        }
    }

}
