package leetcode.algorithms;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 */
public class Q107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        Stack<List<Integer>> stack=new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<>();
            while(size>0){
                root=queue.poll();
                if (root.left!=null){
                    queue.add(root.left);
                }
                if (root.right!=null){
                    queue.add(root.right);
                }
                list.add(root.val);
                size--;
            }
            stack.push(list);
        }
        List<List<Integer>> result=new ArrayList<>();
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;

    }
}
