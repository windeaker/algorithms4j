package leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *102. 二叉树的层序遍历
 *
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Integer> outQueNum=new ArrayDeque<>();
        Queue<TreeNode> nodeQue=new ArrayDeque<>();
        Queue<TreeNode> nodeQue2=new ArrayDeque<>();
        List<List<Integer>> result=new ArrayList<>();
        while(root!=null){
            nodeQue.add(root);

        }
        return null;
    }
}
