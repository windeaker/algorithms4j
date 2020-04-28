package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            if (root!=null){
                result.add(root.val);
                stack.push(root.right);
                root=root.left;
            }else{
                root=stack.pop();
            }
        }
        return result;
    }

    public List<Integer> preorderTraversalByRecursive(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root!=null){
            preorderTraversalByRecursive(root,result);
        }
        return result;
    }

    public void preorderTraversalByRecursive(TreeNode root,List<Integer> result) {
        if (root!=null) {
            result.add(root.val);
            preorderTraversalByRecursive(root.left, result);
            preorderTraversalByRecursive(root.right, result);
        }
    }
}
