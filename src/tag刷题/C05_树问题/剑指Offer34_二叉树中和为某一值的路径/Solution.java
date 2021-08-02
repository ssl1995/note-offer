package tag刷题.C05_树问题.剑指Offer34_二叉树中和为某一值的路径;


import tag刷题.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private List<List<Integer>> res;
    private ArrayList<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        recur(root, target);
        return res;
    }

    private void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }
        // 先序遍历:先记录当前节点值进path
        path.add(root.val);
        target -= root.val;
        // 加入结果集条件:target == 0 && root.left == null && root.right == null
        if (target == 0 && root.left == null && root.right == null) {
            // new ArrayList<>(path)形成新链表放入结果集
            res.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            recur(root.left, target);
        }
        if (root.right != null) {
            recur(root.right, target);
        }
        // 回溯需要移除path末尾元素
        path.remove(path.size() - 1);
    }
}
