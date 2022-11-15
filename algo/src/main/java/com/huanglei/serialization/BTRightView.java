package com.huanglei.serialization;

import java.util.ArrayList;

import com.huanglei.algo.TreeNode;

public class BTRightView {

    public static void main(String[] args) {
        System.out.println("BTRightView");
        TreeNode treeNode = TreeNode.buildTree();
        new BTRightView().solution(treeNode);
    }

    public void solution(TreeNode root) {
        int nextLineCount = 0;
        int currentLineCount = 0;

        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(root);
        currentLineCount = 1;
        if (root != null) {
            System.out.println(root.val);
        }
        while (currentLineCount >= 0 && !list.isEmpty()) {

            if (currentLineCount == 0) {
                currentLineCount = nextLineCount;
                nextLineCount = 0;
                System.out.println(list.get(0));
                continue;
            }
            currentLineCount--;
            TreeNode node = list.get(0);
            list.remove(0);
            if (node.right != null) {
                list.add(node.right);
                nextLineCount++;
            }
            if (node.left != null) {
                list.add(node.left);
                nextLineCount++;
            }
        }

    }

}
