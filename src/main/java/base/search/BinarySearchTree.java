package base.search;

public class BinarySearchTree<E extends Comparable> {

    private BinTreeNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(E data) {
        BinTreeNode preCursor = null;
        BinTreeNode cursor = root;
        int compare = 0;
        while (cursor != null) {
            compare = data.compareTo(cursor.data);
            if (compare == 0) {
                throw new RuntimeException("数据" + data + "已经存在");
            } else if (compare > 0) {
                preCursor = cursor;
                cursor = cursor.right;
            } else {
                preCursor = cursor;
                cursor = cursor.left;
            }
        }
        cursor = new BinTreeNode(data);
        if (compare > 0) {
            preCursor.right = cursor;
        } else if (compare < 0) {
            preCursor.left = cursor;
        } else {
            root = cursor;
        }
        return true;
    }

    private class BinTreeNode<E extends Comparable> {
        E data;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode(E data) {
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
