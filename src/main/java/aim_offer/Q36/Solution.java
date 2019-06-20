package aim_offer.Q36;

import java.util.List;
import java.util.Stack;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。
 * 解题思路
 *
 */
public class Solution {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        ListNode head1=pHead1;
        ListNode head2=pHead2;
        while(head1!=null){
            stack1.push(head1);
            head1=head1.next;
        }
        while(head2!=null){
            stack2.push(head2);
            head2=head2.next;
        }
        ListNode curNode1=null,curNode2=null;
        ListNode comNode=null;
        while(!stack1.empty()||!stack2.empty()){
            if (!stack1.empty()){
                curNode1=stack1.pop();
            }else{
                curNode1=null;
            }
            if (!stack2.empty()){
                curNode2=stack2.pop();
            }else{
                curNode2=null;
            }
            if (curNode1==curNode2){
                comNode=curNode1;
            }else{
                if (comNode==null){
                    return null;
                }else{
                    return comNode;
                }
            }
        }
        return comNode;
    }

    public static void main(String[] args) {
        test1();
//        test2();
//        test3();
//        test4();
    }
    private static void test1() {
        // 第一个公共结点在链表中间
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n6;
        n6.next = n7;
        n4.next = n5;
        n5.next = n6;
        System.out.println(FindFirstCommonNode(n1, n4)); // 6
    }
    private static void test2() {
        // 没有公共结点
        // 1 - 2 - 3 - 4
        //
        // 5 - 6 - 7
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n5.next = n6;
        n6.next = n7;
        System.out.println(FindFirstCommonNode(n1, n5)); // null
    }
    private static void test3() {
        // 公共结点是最后一个结点
        // 1 - 2 - 3 - 4 \
        //                7
        //         5 - 6 /
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n7;
        n5.next = n6;
        n6.next = n7;
        System.out.println(FindFirstCommonNode(n1, n5)); // 7
    }
    private static void test4() {
        // 公共结点是第一个结点
        // 1 - 2 - 3 - 4 - 5
        // 两个链表完全重合
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(FindFirstCommonNode(n1, n1)); // 1
    }
}
