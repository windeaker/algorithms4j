package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Q98 {
    //这个作者厉害，卡Integer边界
    Long last = Long.MIN_VALUE;

    //中序遍历检查
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftResult = isValidBST(root.left);
        if (last < root.val) {
            last = Long.valueOf(root.val);
        } else {
            return false;
        }
        boolean rightResult = isValidBST(root.right);
        return leftResult & rightResult;
    }

    /**
     * 用自定义栈中序实现，提交超时
     *
     * @param root
     * @return
     */
    public boolean wrongSolution2(TreeNode root) {
        boolean result = true;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) {
                root = stack.pop();

                if (!arrayList.isEmpty()) {
                    arrayList.add(root.val);
                } else {
                    if (arrayList.get(arrayList.size() - 1) < root.val) {
                        arrayList.add(root.val);
                    } else {
                        result = false;
                        break;
                    }
                }
                if (root.right != null) {
                    root = root.right;
                }
            } else {
                if (root.left != null) {
                    stack.add(root);
                    root = root.left;
                }
            }
        }
        return result;
    }

    /**
     * Solution错误。过分关注子节点
     *
     * @param root
     * @return
     */
    public boolean errorSolution1(TreeNode root) {
        boolean result = true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.left != null) {
                if (root.left.val >= root.val) {
                    result = false;
                    break;
                } else {
                    queue.add(root.left);
                }
            }
            if (root.right != null) {
                if (root.right.val <= root.val) {
                    result = false;
                    break;
                } else {
                    queue.add(root.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
