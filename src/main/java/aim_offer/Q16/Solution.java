package aim_offer.Q16;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2, head = null;
        if (p1 == null && p2 == null) {
            return null;
        } else if (p1 == null & p2 != null) {
            head=p2;
            p2 = p2.next;
        } else if (p2 == null & p1 != null) {
            head = p1;
            p1 = p1.next;
        } else {
            if (p1.val <= p2.val) {
                head = p1;
                p1 = p1.next;
            } else {
                head = p2;
                p2 = p2.next;
            }
        }
        ListNode point=head;
        while (p1 != null || p2 != null) {
            if (p1 == null & p2 != null) {
                point.next=p2;
                point=point.next;
                p2 = p2.next;
            } else if (p2 == null & p1 != null) {
                point.next=p1;
                point=point.next;
                p1 = p1.next;
            } else {
                if (p1.val <= p2.val) {
                    point.next = p1;
                    point=point.next;
                    p1 = p1.next;
                } else {
                    point.next = p2;
                    point=point.next;
                    p2 = p2.next;
                }
            }
        }
        return head;
    }
}
