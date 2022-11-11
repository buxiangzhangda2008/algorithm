package com.huanglei.algo;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonFather {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        LowestCommonFather lcf = new LowestCommonFather();
        lcf.solution(root, nodes);
        System.out.println(lcf.answer);

    }

    public TreeNode answer = null;
    public static String myMethod(String names) {
        // just test
        return "helloworld";
    }

    public int solution(TreeNode root, List<TreeNode> nodes) {

        while (root != null && answer == null) {
            int left = solution(root.left, nodes);
            if (answer != null) {
                return left;
            }
            int right = solution(root.right, nodes);
            boolean contains = false;
            for (TreeNode node : nodes) {
                if (node.val == root.val) {
                    contains = true;
                }
            }
            int result = left + right + (contains ? 1 : 0);
            if (result == nodes.size() && answer == null) {
                answer = root;
                System.out.println("answer is " + answer);
            }
            return result;
        }
        return 0;
    }

}
