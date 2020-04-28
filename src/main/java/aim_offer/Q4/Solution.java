package aim_offer.Q4;

/**
 * @author windeaker
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        return buildNode(pre,0,in,0,in.length);
    }

    public TreeNode buildNode(int [] pre,int preStart,int [] in,int inStart,int inEnd){
        if (preStart>=pre.length){
            return null;
        }
        int nodeVal=pre[preStart];
        int index=-1;
        for(int i=inStart;i<inEnd;i++){
            if (in[i]==nodeVal){
                index=i;
                break;
            }
        }
        if (index!=-1){
            TreeNode treeNode=new TreeNode(nodeVal);
            treeNode.left=buildNode(pre,preStart+1,in,inStart,index);
            treeNode.right=buildNode(pre,preStart+1+index-inStart,in,index+1,inEnd);
            return treeNode;
        }else{
            return null;
        }
    }

    /**
     * @param pre
     * @param ps
     * @param pe
     * @param in
     * @param is
     * @param ie
     * @return
     */
    private TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if(ps > pe) return null;

        // 取前序遍历的第一个数字就是根节点
        int value = pre[ps];
        // 在中序遍历中中寻找根节点
        int index =is;
        while(index <= ie && value != in[index]) {
            index ++;
        }
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常
        if(index > ie)
            throw new RuntimeException("Invalid Iuput!");

        // 创建当前根节点，并为根节点赋值
        TreeNode node = new TreeNode(value);
        // 递归调用构建当前节点的左子树
        node.left = construct(pre, ps+1, ps+index-is, in, is, index-1);
        // 递归调用构建当前节点的右子树
        node.right = construct(pre, ps+index-is+1, pe, in, index+1, ie);

        return node;
    }



    public static void printTreePreOrder(TreeNode node){
        if (node!=null) {
            System.out.println(node.val);
            printTreePreOrder(node.left);
            printTreePreOrder(node.right);
        }
    }

    public static void printTreeInOrder(TreeNode node){
        if (node!=null) {
            printTreeInOrder(node.left);
            System.out.println(node.val);
            printTreeInOrder(node.right);
        }
    }

    public static void printTreePostOrder(TreeNode node){
        if (node!=null) {
            printTreePostOrder(node.left);
            printTreePostOrder(node.right);
            System.out.println(node.val);
        }
    }

    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};
        TreeNode treeNode=new Solution().reConstructBinaryTree(pre,in);
        printTreePreOrder(treeNode);
        System.out.println("************************************");
        printTreeInOrder(treeNode);
        System.out.println("************************************");
        printTreePostOrder(treeNode);
    }

}
