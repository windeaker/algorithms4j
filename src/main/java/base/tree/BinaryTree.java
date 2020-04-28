package base.tree;


import leetcode.algorithms.TreeNode;

import java.util.*;

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


    private List<E> preOrderWithStack(BNode root){
        List<E> result=new ArrayList<>();
        Stack<BNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            if (root!=null){
                result.add((E)root.value);
                stack.push(root.right);
                root=root.left;
            }else{
                root=stack.pop();
            }
        }
        return result;
    }

    private void inOrderWithStack(BNode root){
//        if (cursor!=null&&list!=null){
//            inOrderWithRecursion(cursor.left,list);
//            list.add((E)cursor.value);
//            inOrderWithRecursion(cursor.right,list);
//        }
    }

    /**
     * 利用Set保存已经加入的节点信息。其实保存上一个访问的节点地址就行了详情看
     * @see leetcode.algorithms.Q145
     * @param root
     * @return
     */
    private List<E> postOrderWithStack(BNode root){
        Stack<BNode> stack = new Stack<>();
        List<E> result = new ArrayList<>();
        HashSet<BNode> nodeSet = new HashSet<>();
        while (root != null || !stack.isEmpty()) {
            if (null!=root) {
                if (root.left != null && !nodeSet.contains(root.left)) {
                    stack.push(root);
                    root = root.left;
                } else if (root.right != null && !nodeSet.contains(root.right)) {
                    stack.push(root);
                    root = root.right;
                } else {
                    result.add((E)root.value);
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
     * 层次遍历
     * @param root 树的根节点
     * @return
     */
    public List<E> levelOrder(BNode root){
        Queue<BNode> queue=new ArrayDeque<>();
        List<E> result=new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root=queue.poll();
            if (null!=root){
                result.add((E)root.value);
                if (root.left!=null){
                    queue.add(root.left);
                }
                if (root.right!=null){
                    queue.add(root.right);
                }
            }
        }
        return result;
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
