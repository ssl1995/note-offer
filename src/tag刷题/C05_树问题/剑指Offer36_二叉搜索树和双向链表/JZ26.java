package tag刷题.C05_树问题.剑指Offer36_二叉搜索树和双向链表;

import tag刷题.utils.TreeNode;

public class JZ26 {
    private TreeNode pre;
    private TreeNode head;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs(pRootOfTree);
        return head;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

}
