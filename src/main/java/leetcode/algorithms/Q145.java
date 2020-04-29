package leetcode.algorithms;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class Q145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        HashSet<TreeNode> nodeSet = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            if (null!=root) {
                if (root.left != null && !nodeSet.contains(root.left)) {
                    stack.push(root);
                    root = root.left;
                } else if (root.right != null && !nodeSet.contains(root.right)) {
                    stack.push(root);
                    root = root.right;
                } else {
                    result.add(root.val);
                    nodeSet.add(root);
                    if (!stack.isEmpty()) {
                        root = stack.pop();
                    } else {
                        root = null;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 用保存上一个节点的地址，效率更高 参考别人的
     * @param root
     * @return
     */
    public List<Integer> postorderTraversalPlus(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if((curr.left == null && curr.right == null) ||
                    (pre != null && (pre == curr.left || pre == curr.right))){
                //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
                res.add(curr.val);
                pre = curr;
                stack.pop();
            }else{
                if(curr.right != null) {
                    stack.push(curr.right); //先将右结点压栈
                }
                if(curr.left != null) {
                    stack.push(curr.left);   //再将左结点入栈
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode cursor=root;
        cursor.right=new TreeNode(2);
        cursor=cursor.right;
        cursor.left=new TreeNode(3);
        new Q145().postorderTraversal(root);
    }
}
