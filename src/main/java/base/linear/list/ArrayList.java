package base.linear.list;

public class ArrayList<E> {
    int size=0;
    Object[] array;
    public final static int DEFAULT_CAPACITY=16;

    public ArrayList(){
        array=new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity){
        array=new Object[capacity];
    }

    public ArrayList(E[] element){

    }
}
