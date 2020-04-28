package leetcode.algorithms;

import java.util.List;
import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Q2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode point = l1, firstNode = null;
        long a1 = 0, a2 = 0;
        int i = 0;
        do {
            long temp = (long) Math.pow(10, i);
            a1 += (point.val * temp);
            i++;
            point = point.next;
        } while (point != null);

        point = l2;
        i = 0;
        do {
            long temp = (long) Math.pow(10, i);
            a2 += (point.val * temp);
            i++;
            point = point.next;
        } while (point != null);
        long sum = a1 + a2;
        point = null;

        if (sum!=0) {
            while (sum > 0) {
                int remainder = (int)(sum % 10);
                sum = sum / 10;
                ListNode pointTemp = new ListNode(remainder);
                pointTemp.next = null;
                if (point != null) {
                    point.next = pointTemp;
                    point = pointTemp;
                } else {
                    firstNode = point = pointTemp;
                }
            }

        }else{
            firstNode=new ListNode(0);
            firstNode.next=null;
        }
        return firstNode;
    }

    public static void main(String[] args) {
//        ListNode a1 = new ListNode(2), a2 = new ListNode(4), a3 = new ListNode(3);
//        ListNode b1 = new ListNode(5), b2 = new ListNode(6), b3 = new ListNode(4);
//
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = null;
//        b1.next = b2;
//        b2.next = b3;
//        b3.next = null;
        ListNode a1 = new ListNode(9);
        ListNode b1 = new ListNode(1),b2 = new ListNode(9),b3 = new ListNode(9),b4 = new ListNode(9),b5 = new ListNode(9),b6 = new ListNode(9),b7 = new ListNode(9),b8 = new ListNode(9),b9 = new ListNode(9),b10 = new ListNode(9);
        b1.next=b2;
        b2.next=b3;
        b3.next=b4;
        b4.next=b5;
        b5.next=b6;
        b6.next=b7;
        b7.next=b8;
        b8.next=b9;
        b9.next=b10;
        b10.next=null;
        ListNode point = addTwoNumbers(a1, b1);

        do {
            System.out.println(point.val);
            point=point.next;
        } while (point != null);
    }

}
