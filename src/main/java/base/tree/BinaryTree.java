package base.tree;


import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E> {

    transient BNode root;

    public static class BNode<E>{
        BNode left;
        BNode right;
        E value;
        public BNode(BNode left,E element,BNode right){
            this.left=left;
            this.value=element;
            this.right=right;
        }

        public BNode(E value){
            this(null,value,null);
        }
    }

    public void addValue(BNode pNode,E value,boolean left0rRight){
        addBNode(pNode,new BNode(value),left0rRight);
    }


    public void addBNode(BNode pNode,BNode nNode,boolean left0rRight){
        if (left0rRight){
            pNode.left=nNode;
        }else{
            pNode.right=nNode;
        }
    }

    /**
     * 遍历类型
     */
    public enum TraversalType{
        NLR,LNR,LRL
    }

    public List<E> traversingFromRoot(BNode root,TraversalType type){
        if (root!=null){
            List<E> resultSet=new ArrayList<>();
            switch (type){
                case NLR:
                    preOrderWithRecursion(root,resultSet);
                    break;
                case LNR:
                    inOrderWithRecursion(root,resultSet);
                    break;
                case LRL:
                    postOrderWithRecursion(root,resultSet);
                    break;
                default:
                    break;
            }
        }
        return null;

    }

    private void preOrderWithRecursion(BNode cursor,List<E> list){
        if (cursor!=null&&list!=null){
            list.add((E)cursor.value);
            preOrderWithRecursion(cursor.left,list);
            preOrderWithRecursion(cursor.right,list);
        }
    }

    private void inOrderWithRecursion(BNode cursor,List<E> list){
        if (cursor!=null&&list!=null){
            inOrderWithRecursion(cursor.left,list);
            list.add((E)cursor.value);
            inOrderWithRecursion(cursor.right,list);
        }
    }

    private void postOrderWithRecursion(BNode cursor,List<E> list){
        if (cursor!=null&&list!=null){
            postOrderWithRecursion(cursor.left,list);
            postOrderWithRecursion(cursor.right,list);
            list.add((E)cursor.value);
        }
    }

    /**
     * 通过前序和中序遍历重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public BNode buildBTreeFromPreAndInOrderRecursion(int [] pre,int [] in) {
        return buildBTreeFromPreAndInOrderRecursionWithLimit(pre,0,in,0,in.length);
    }

    private BNode buildBTreeFromPreAndInOrderRecursionWithLimit(int [] pre,int preStart,int [] in,int inStart,int inEnd){
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
            BNode treeNode=new BNode(nodeVal);
            treeNode.left=buildBTreeFromPreAndInOrderRecursionWithLimit(pre,preStart+1,in,inStart,index);
            treeNode.right=buildBTreeFromPreAndInOrderRecursionWithLimit(pre,preStart+1+index-inStart,in,index+1,inEnd);
            return treeNode;
        }else{
            return null;
        }
    }







}
