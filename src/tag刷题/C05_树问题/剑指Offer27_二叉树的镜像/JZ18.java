package tag刷题.C05_树问题.剑指Offer27_二叉树的镜像;

import tag刷题.utils.TreeNode;

public class JZ18 {

    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}
