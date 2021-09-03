package com.huanglei.algo;

public class BTCommonParent {

    private TreeNode ans;

    public BTCommonParent() {
        this.ans = null;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        System.out.println(root.val);
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
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
        new BTCommonParent().lowestCommonAncestor(root,node1,node2);
    }
}
