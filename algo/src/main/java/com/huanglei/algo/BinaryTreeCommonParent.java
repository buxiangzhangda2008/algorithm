package com.huanglei.algo;

// import apple.laf.JRSUIUtils;

import java.util.*;

public class BinaryTreeCommonParent {
//    public static void main(String[] args) {
//        TreeNode node1 = TreeNode.buildTree();
//        Set<Integer> integers = new HashSet<>();
//        integers.add(8);
//        integers.add(10);
//        integers.add(9);
//        TreeNode node = lowestCommonAncestor(node1, integers);
//        System.out.println(node.val);
//    }
//
//
//    static Stack<TreeNode> list = new Stack<>();
//
//    public static TreeNode lowestCommonAncestor(TreeNode root, Set<Integer> targets) {
//        frontTraverse(root, targets, list);
//        //遍历找到p或q，记录找到的路径
//        TreeNode candidate = null;
//        while (!list.isEmpty()) {
//            candidate = list.pop();
//            while (frontTraverse(candidate, targets, null) != null) {
//            }
//            if (targets.isEmpty()) {
//                return candidate;
//            }
//        }
//        return candidate;
//    }
//
//    public static TreeNode frontTraverse(TreeNode root, Set<Integer> targets, Stack<TreeNode> path) {
//        if (root == null) {
//            return null;
//        }
//        if (targets.contains(root.val)) {
//            if (path != null) path.push(root);
//            targets.remove(root.val);
//            return root;
//        }
//        if (path != null) path.push(root);
//        TreeNode target = frontTraverse(root.left, targets, path);
//        if (target != null) {
//            return target;
//        }
//        if (path != null) path.pop();
//        target = frontTraverse(root.right, targets, path);
//        if (target != null) {
//            return target;
//        }
//        return null;
//    }
//
//
//    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
//    Set<Integer> visited = new HashSet<Integer>();
//
//    public void dfs(TreeNode root) {
//        if (root.left != null) {
//            parent.put(root.left.val, root);
//            dfs(root.left);
//        }
//        if (root.right != null) {
//            parent.put(root.right.val, root);
//            dfs(root.right);
//        }
//    }
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        dfs(root);
//        while (p != null) {
//            visited.add(p.val);
//            p = parent.get(p.val);
//        }
//        while (q != null) {
//            if (visited.contains(q.val)) {
//                return q;
//            }
//            q = parent.get(q.val);
//        }
//        return null;
//    }
    static TreeNode result = null;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left=new TreeNode(9);
        root.right=new TreeNode(8);
        root.left.left=new TreeNode(7);
        root.left.right=new TreeNode(0);
        root.left.right.left=new TreeNode(11);
        root.left.right.right=new TreeNode(18);
        root.right.left=new TreeNode(3);
        root.right.left=new TreeNode(4);
        Set<Integer> req = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        req.add(0);
        req.add(11);
        req.add(18);
        post(root,req,set);
        System.out.println(result.val);
    }
    private static boolean post(TreeNode root,Set<Integer> req,Set<Integer> set){
        if(root==null)return false;
        boolean left = post(root.left,req,set);
        boolean right = post(root.right,req,set);
        if(req.contains(root.val)){
            req.remove(root.val);
            if(req.size()==0)result=root;
            return true;
        }
        if(req.size()==0&&result==null){
            result = root;
        }
        return true;
    }
}
//class TreeNode{
//    int val;
//    TreeNode left;
//    TreeNode right;
//    public TreeNode(int val){
//        this.val = val;
//    }
//}
//}
