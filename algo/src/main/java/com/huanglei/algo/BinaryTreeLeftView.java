package com.huanglei.algo;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLeftView {
    public static void main(String[] args) {
       TreeNode node1 = TreeNode.buildTree();
        System.out.println(new BinaryTreeLeftView().getLeftView(node1));
    }
    public List<TreeNode> getLeftView(TreeNode root){
        List<TreeNode> leftView = new ArrayList<>();
        List<TreeNode> currLevel = new ArrayList<>();
        currLevel.add(root);
        while(!currLevel.isEmpty()){
            leftView.add(currLevel.get(0));
            currLevel = getNextLevel(currLevel);
        }
        return leftView;
    }
    private List<TreeNode> getNextLevel(List<TreeNode> level){
        List<TreeNode> nextLevel = new ArrayList<>();
        for(TreeNode TreeNode:level){
            if(TreeNode.left!=null){
                nextLevel.add(TreeNode.left);
            }
            if(TreeNode.right!=null){
                nextLevel.add(TreeNode.right);
            }
        }
        return nextLevel;
    }



}
