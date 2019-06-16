package base.tree;

public class BinaryTree<E> {

    transient int size=0;

    transient TreeNode rootNode;

    public static class TreeNode<E>{
        TreeNode leftSubNode;
        TreeNode rightSubNode;
        E element;
        public TreeNode(TreeNode leftSubNode,E element,TreeNode rightSubNode){
            this.leftSubNode=leftSubNode;
            this.element=element;
            this.rightSubNode=rightSubNode;
        }

        public TreeNode(E element){
            this(null,element,null);
        }
    }

    public void clear(){

    }

    public void remove(TreeNode node){

    }

    public void addLeftSubTree(TreeNode parentNode,TreeNode subTreeRootNode){

    }

    public void addRightSubTree(TreeNode parentNode,TreeNode subTreeRootNode){

    }

    public enum traversal{
        NLR,LNR,LRL
    }






}
