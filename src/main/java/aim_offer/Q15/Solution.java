package aim_offer.Q15;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp, current = head, next = null;
        temp = current.next;
        current.next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = current;
            current = temp;
            temp = next;
        }
        return current;
    }
}
