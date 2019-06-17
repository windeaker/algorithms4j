package aim_offer;

import aim_offer.Q14.Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Q13 {
    public void reOrderArray(int [] array) {
        List<Integer> oddNums=new ArrayList<Integer>();
        List<Integer> evenNums=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++){
            if ((array[i]%2)!=0){
                oddNums.add(array[i]);
            }else{
                evenNums.add(array[i]);
            }
        }
        int oddSize=oddNums.size();
        for(int i=0;i<array.length;i++){
            if (i<oddSize){
                array[i]=oddNums.get(i);
            }else{
                array[i]=evenNums.get(i-oddSize);
            }
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7};
        new Q13().reOrderArray(array);
    }
}
