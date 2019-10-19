package base.linear.list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleArrayList<E>{
    private final static int DEFAULT_CAPACITY = 10;
    private final static int MAX_CAPACITY = Integer.MAX_VALUE;

    private Object[] elements = new Object[0];

    private int size;


    public SimpleArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean add(E element) {
        boolean addResult = false;
        checkForExpand(size + 1);
        elements[++size] = element;
        return addResult;
    }

    private void checkForExpand(int miniCapacity) {
        miniCapacity = Math.max(DEFAULT_CAPACITY, miniCapacity);
        if (elements.length < miniCapacity) {
            expand(miniCapacity);
        }
    }

    private void expand(int miniCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 2);

        if (newCapacity < miniCapacity) {
            newCapacity = miniCapacity;
        }
        if (newCapacity > MAX_CAPACITY) {
            throw new OutOfMemoryError();
        }
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldElem = (E) elements[index];
        System.arraycopy(elements, index, elements, index - 1, size - index);
        size--;
        return oldElem;
    }

    public E remove(E elem) {
        int index=indexOf(elem);
        if (index==-1){
            return null;
        }else{
            return remove(index);
        }
    }

    public int indexOf(Object object) {
        int i = 0;
        if (object == null) {
            for (Object obj : elements) {
                if (obj == null) {
                    return i;
                }
                i++;
            }
        } else {
            for (Object obj : elements) {
                if (object.equals(obj)) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }


    public void add(int index, E newElem) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (index == size) {
            add(newElem);
        } else {
            checkForExpand(size + 1);
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
    }

    public E set(int index, E newElem) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldElem = (E) elements[index];
        elements[index] = newElem;
        return oldElem;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) elements[index];
    }

    public int getSize() {
        return size;
    }
}
