package base.linear.list;

public class SimpleLinkList<E> {

    private Node<E> root;

    private int size;

    private Node<E> lastNode;

    public SimpleLinkList() {
        size = 0;
        root = lastNode = null;
    }

    public int getSize() {
        return size;
    }

    public void add(E elem) {
        Node<E> newNode = new Node<>(elem);
        if (root == null) {
            root = lastNode = newNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
        size++;
    }

    public void add(int index, E elem) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> newNode = new Node<>(elem);
        if (index == 0) {
            newNode.next = root;
            root = newNode;
        } else if (index == size) {
            lastNode.next = newNode;
            lastNode = newNode;
        } else {
            Node<E> cursor = root;
            // 起点设置为1 这样cursor 总能指向index的上一个节点
            for (int i = 1; i < index; i++) {
                cursor = cursor.next;
            }
            newNode.next = cursor.next;
            cursor.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = null;
        if (index == 0) {
            temp = root;
            root = root.next;
            temp.next = null;
        } else {
            Node<E> cursor = root;
            // 起点设置为1 这样cursor 总能指向index的上一个节点
            for (int i = 1; i < index; i++) {
                cursor = cursor.next;
            }
            temp = cursor.next;
            cursor.next = temp.next;
            temp.next = null;
        }
        size--;
        return temp.data;
    }

    public E remove(E elem) {
        Node<E> preCursor = null;
        Node<E> cursor = root;
        if (elem == null) {
            while (cursor != null) {
                if (cursor.data == null) {
                    break;
                }
                preCursor=cursor;
                cursor=cursor.next;
            }
        } else {
            while (cursor != null) {
                if (elem.equals(cursor.data)) {
                    break;
                }
                preCursor=cursor;
                cursor=cursor.next;
            }
        }
        Node<E> temp = null;
        if (preCursor!=null){
            temp=cursor;
            preCursor.next=temp.next;
            temp.next=null;
        }else{
            temp = root;
            root = root.next;
            temp.next = null;
        }
        return temp.data;
    }

    public E set(int index, E elem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> cursor = root;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        E temp=cursor.data;
        cursor.data=elem;
        return temp;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> cursor = root;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor.data;
    }


    private class Node<E> {
        Node<E> next;
        E data;

        public Node(E e) {
            data = e;
            next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
