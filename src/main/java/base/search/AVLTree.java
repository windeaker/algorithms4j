package base.search;

import sun.invoke.util.VerifyAccess;

import java.util.List;

/**
 * 平衡二叉树 AVL
 * 定义：1.二叉排序树 2.左右子树都是平衡二叉树，左右子树高度差的绝对值之差不超过1
 * @param <E>
 */
public class AVLTree<E extends Comparable> {
    private AVLNode<E> root;
    public AVLTree(){
        root=null;
    }

    public void buildAVLTreeFromList(List<E> originList){

    }

    public void addValue(E value){
        AVLNode<E> nNode=new AVLNode<>(value);
    }
    public void delValue(){

    }

    public AVLNode<E> getValue(){

    }

    public void setValue(){

    }

    private boolean checkForAdd(){

    }

    private boolean balanceAjust(){

    }


    private AVLNode<E> llRotate(AVLNode oldNode){
        AVLNode nNode=oldNode.left;
        AVLNode temp=nNode.right;
        nNode.right=oldNode;
        oldNode.left=temp;

        oldNode.high=Math.max(oldNode.left.high,oldNode.right.high)+1;
        nNode.high=Math.max(nNode.left.high,nNode.right.high)+1;
        return nNode;
    }

    private AVLNode<E> lrRotate(AVLNode oldNode){
        oldNode.left=rrRotate(oldNode.left);
        return llRotate(oldNode);
    }

    private AVLNode<E> rlRotate(AVLNode oldNode){
        oldNode.right=llRotate(oldNode.right);
        return rrRotate(oldNode);
    }

    private AVLNode<E> rrRotate(AVLNode oldNode){
        AVLNode nNode=oldNode.right;
        AVLNode temp=nNode.left;
        nNode.left=oldNode;
        oldNode.right=temp;

        oldNode.high=Math.max(oldNode.left.high,oldNode.right.high)+1;
        nNode.high=Math.max(nNode.left.high,nNode.right.high)+1;
        return nNode;

    }
    public class AVLNode<E extends Comparable>{
        int high;
        E value;
        AVLNode<E> left;
        AVLNode<E> right;
        AVLNode<E> parent;

        public AVLNode(E value){
            this.value=value;
            this.high=0;
            left=right=parent=null;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public AVLNode<E> getLeft() {
            return left;
        }

        public void setLeft(AVLNode<E> left) {
            this.left = left;
        }

        public AVLNode<E> getRight() {
            return right;
        }

        public void setRight(AVLNode<E> right) {
            this.right = right;
        }

        public AVLNode<E> getParent() {
            return parent;
        }

        public void setParent(AVLNode<E> parent) {
            this.parent = parent;
        }

        public void highIncre(){
            high++;
        }

        public void highDecre(){
            high--;
        }

        public int absHigh(AVLNode<E> comapre){
            return Math.abs(high-comapre.getHigh());
        }

        @Override
        public String toString() {
            return "Node{" +
                    "high=" + high +
                    ", value=" + value +
                    '}';
        }
    }

    public enum AjustType{
        LL,LR,RR,RL;
    }
}
