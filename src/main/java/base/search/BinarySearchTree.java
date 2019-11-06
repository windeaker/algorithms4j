package base.search;

import java.util.List;

/**
 * BinarySearchTree 二叉搜索排序树（BST）
 * 定义：
 * 1. 是个二叉树，或者空树，如果是二叉树，需要满足2,3
 * 2. 若左子树不为空，则左子树上所有关键字的值均小于根关键字的值。
 * 3. 若右子树不为空，则右子树上所有关键字的值均小于根关键字的值。
 *
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable> {

    private BSTNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean add(E data) {
        if (data == null) {
            throw new NullPointerException("数值不能为空");
        }
        BSTNode preCursor = null;
        BSTNode cursor = root;
        int compare = 0;
        while (cursor != null) {
            compare = data.compareTo(cursor.data);
            if (compare == 0) {
                throw new RuntimeException("数据" + data + "已经存在");
            } else if (compare > 0) {
                //cursor小于key
                preCursor = cursor;
                cursor = cursor.right;
            } else {
                preCursor = cursor;
                cursor = cursor.left;
            }
        }
        cursor = new BSTNode(data);
        if (compare > 0) {
            preCursor.right = cursor;
        } else if (compare < 0) {
            preCursor.left = cursor;
        } else {
            root = cursor;
        }
        return true;
    }

    public void buildBstFromList(List<E> origins) {
        if (origins != null && !origins.isEmpty()) {
            clear();
            for (E data : origins) {
                add(data);
            }
        }
    }

    public E delete(E key) {
        BSTNode preCursor = null;
        BSTNode cursor = root;
        int compare;
        //cursor是不是父节点的左子树
        boolean isLeft=true;
        while (cursor != null) {
            compare = key.compareTo(cursor.data);
            if (compare == 0) {
                break;
            } else if (compare > 0) {
                //cursor小于key
                preCursor = cursor;
                cursor = cursor.right;
                isLeft=false;
            } else {
                preCursor = cursor;
                cursor = cursor.left;
                isLeft=true;
            }
        }
        if (cursor.left == null && cursor.right == null) {
            simpleDelNode(isLeft,preCursor,null);
        } else if (cursor.left == null && cursor.right != null) {
            simpleDelNode(isLeft,preCursor,cursor.right);
        } else if (cursor.left != null && cursor.right == null) {
            simpleDelNode(isLeft,preCursor,cursor.left);
        } else if (cursor.left != null && cursor.right != null) {
            //找到左子树的最大值节点，和cursor对换，然后删掉最大值节点
            //或者找到右子树的最小值节点和，cursor对换值，然后删掉最小值节点
            //这里以左子树为例
            BSTNode maxPreCursor=cursor;
            BSTNode maxCursor=maxPreCursor.right;
            while(maxCursor.right!=null){
                maxPreCursor=maxCursor;
                maxCursor=maxPreCursor.right;
            }

            Comparable temp=cursor.data;
            cursor.data=maxCursor.data;
            if (maxCursor.left==null){
                simpleDelNode(false,maxPreCursor,null);
            }else{
                simpleDelNode(false,maxPreCursor,maxCursor.left);
            }
            return (E)temp;
        }
        return (E)cursor.data;
    }

    public void simpleDelNode(boolean isLeft,BSTNode preCursor,BSTNode nextNode){
        if (null==preCursor){
            root=nextNode;
        }else {
            if(isLeft){
                preCursor.left = nextNode;
            }else{
                preCursor.right = nextNode;
            }
        }
    }

    public void set(E old, E nVal) {
        BSTNode cursor = get(old);
        if (cursor != null) {
            cursor.data = nVal;
        }
    }

    public BSTNode<E> get(E key) {
        if (key != null) {
            BSTNode cursor = root;
            int compare;
            while (cursor != null) {
                compare = cursor.data.compareTo(cursor.data);
                if (compare == 0) {
                    return cursor;
                } else if (compare > 0) {
                    // cursor 大于key
                    cursor = cursor.left;
                } else {
                    cursor = cursor.right;
                }
            }
            return cursor;
        } else {
            return null;
        }
    }

    public BSTNode clear() {
        BSTNode cursor = root;
        root = null;
        return cursor;
    }


    private class BSTNode<E extends Comparable> {
        E data;
        BSTNode left;
        BSTNode right;

        public BSTNode(E data) {
            left = null;
            right = null;
            this.data = data;
        }


        @Override
        public String toString() {
            return "BinTreeNode{" +
                    "data=" + data +
                    '}';
        }
    }
}
