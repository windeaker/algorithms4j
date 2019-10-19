package base.linear.list;

public class SimpleLinkListWithDoubleLink<E> {
    private Node<E> root;

    private int size;

    private Node<E> lastNode;

    public SimpleLinkListWithDoubleLink() {
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
            newNode.pre=lastNode;
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
            root.pre=newNode;
            root = newNode;
        } else if (index == size) {
            lastNode.next = newNode;
            newNode.pre=lastNode;
            lastNode = newNode;
        } else {
            Node<E> cursor = root;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            newNode.next = cursor;
            newNode.pre=cursor.pre;
            cursor.pre=newNode;
            newNode.pre.next=newNode;
        }
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> cursor = root;
        if (index == 0) {
            cursor.next.pre=null;
            root = cursor.next;
            cursor.next = null;
            cursor.pre = null;
        } else {
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            cursor.pre.next=cursor.next;
            cursor.next.pre=cursor.pre;
            cursor.next = null;
            cursor.pre = null;
        }
        size--;
        return cursor.data;
    }

    public E remove(E elem) {
        Node<E> cursor = root;
        if (elem == null) {
            while (cursor != null) {
                if (cursor.data == null) {
                    break;
                }
                cursor = cursor.next;
            }
        } else {
            while (cursor != null) {
                if (elem.equals(cursor.data)) {
                    break;
                }
                cursor = cursor.next;
            }
        }
        if (cursor.pre != null) {
            cursor.pre.next=cursor.next;
            cursor.next.pre=cursor.pre;
            cursor.next = null;
            cursor.pre = null;
        } else {
            cursor.next.pre=null;
            root = cursor.next;
            cursor.next = null;
            cursor.pre = null;
        }
        return cursor.data;
    }

    public E set(int index, E elem) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> cursor = root;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        E temp = cursor.data;
        cursor.data = elem;
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
        Node<E> pre;
        E data;

        public Node(E e) {
            data = e;
            next = null;
            pre = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
