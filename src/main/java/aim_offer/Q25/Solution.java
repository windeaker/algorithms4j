package aim_offer.Q25;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree!=null) {
            TreeNode leftNode=Convert(pRootOfTree.left);
            TreeNode rightNode=Convert(pRootOfTree.right);



        }
        return null;
    }
}
