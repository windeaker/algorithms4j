package leetcode.algorithms;

import common.CommonUtil;

public class Q19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPoint=head;
        ListNode slowPointPre=new ListNode(0);
        slowPointPre.next=head;
        int i=1;
        while(fastPoint.next!=null){
            if (i>=n){
                slowPointPre=slowPointPre.next;
            }
            fastPoint=fastPoint.next;
            i++;
        }
        slowPointPre.next=slowPointPre.next.next;
        return head;
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
