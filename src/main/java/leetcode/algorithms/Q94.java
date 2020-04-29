package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        TreeNode current=root;
        while(!stack.isEmpty()||current!=null){
            if (current!=null){
                stack.push(current);
                current=current.left;
            }else{
                current=stack.pop();
                if (current!=null) {
                    result.add(current.val);
                    current=current.right;
                }
            }
        }
        return result;
    }

    //不推荐此方法，仅作参考
    public List<Integer> inorderTraversalLower(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> result=new ArrayList<>();
        TreeNode current=root;
        while(!stack.isEmpty()||current!=null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }
}
