package leetcode.algorithms;

import common.CommonUtil;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class Q19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head,slowCur=new ListNode(-1),pre=new ListNode(-1);
        slowCur.next=head;
        pre.next=slowCur;
        int count=1;
        //至少进行一次循环，所以slowCur始终指向要被删除的节点
        while(cur!=null){
            cur=cur.next;
           if (count>=n){
               slowCur=slowCur.next;
               pre=pre.next;
           }
           count++;
        }
        pre.next=slowCur.next;
        //如果被删的是头节点，头节点指向第二个节点
        if (slowCur==head){
            head=slowCur.next;
        }
        return head;
    }

    /**
     * 两次遍历法，不推荐
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEndSample(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }




    public static void main(String args[]){
        int[] a=new int[]{1,2};
        ListNode head=new ListNode(2),current=head,pre=null;

        for(int b:a){
            if (pre==null){
                current.val=b;
            }else{
                current=new ListNode(b);
                pre.next=current;
            }
            pre=current;
            current=current.next;
        }
        removeNthFromEnd(head,2);
    }
}
