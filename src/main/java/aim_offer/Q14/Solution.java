package aim_offer.Q14;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode tailPoint=head,headPoint=head;
        int count=0;
        while(headPoint!=null){
            headPoint=headPoint.next;
            if (count>=k){
                tailPoint=tailPoint.next;
            }
            count++;
        }
        if (k>count){
            return null;
        }
        return tailPoint;
    }
}
