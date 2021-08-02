package tag刷题.C05_树问题.剑指Offer37_序列化与反序列化二叉树;

import tag刷题.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class JZ61 {

    String Serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // node值不为null
            if (node != null) {
                sb.append(node.val).append(",");
                // 队列每次放出队结点的左右结点即可,因为root已经是二叉树
                queue.add(node.left);
                queue.add(node.right);
            } else { // node值为null,结果字符串加null+,
                sb.append("null,");
            }
        }
        // 删除最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str.equals("[]")) {
            return null;
        }
        // 去掉头尾的"[]"，并根据逗号分离成字符串数组
        String[] split = str.substring(1, str.length() - 1).split(",");
        // 生产根节点
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        // 队列维持左右孩子
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{
            add(root);
        }};
        // 根节点已生成,遍历指针从1下标开始
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!split[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(split[index]));
                queue.add(node.left);
            }
            index++;
            if (!split[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(split[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
