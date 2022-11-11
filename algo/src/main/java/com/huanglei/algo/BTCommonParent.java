package com.huanglei.algo;

import java.util.HashMap;
import java.util.HashSet;

public class BTCommonParent {

    private TreeNode ans;

    public BTCommonParent() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        System.out.println(root.val);
        boolean lson = dfs(root.left, p, q);
        boolean rson = false;
        if(ans==null) {
            rson = dfs(root.right, p, q);
        }
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        if(root.val==p.val||root.val==q.val){
            if(lson||rson) ans = root;
        }else if(lson&&rson){
            ans = root;
        }

        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return this.ans;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
        TreeNode node1 = TreeNode.buildNode(10);
        TreeNode node2 = TreeNode.buildNode(9);
        TreeNode treeNode = new BTCommonParent().commonAncestor(root, node1, node2);
        System.out.println("answer is:" +treeNode.val);
    }
    private HashMap<Integer,TreeNode> parent = new HashMap<>();
    
    public void dfs(TreeNode root) {

        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
    private HashSet<TreeNode> path = new HashSet<>();
    public TreeNode commonAncestor(TreeNode root,TreeNode p,TreeNode q){
        dfs(root);
        while(p!=null){
            path.add(p);
            p = parent.get(p.val);
        }
        while(q!=null){
            if(path.contains(q)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
    
}
