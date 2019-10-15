package test;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
    public static void main(String[] args) {
        ArrayList<Integer> intArrayList=new ArrayList<Integer>();
        intArrayList.add(1);
        Iterator<Integer> iterator=intArrayList.iterator();
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
