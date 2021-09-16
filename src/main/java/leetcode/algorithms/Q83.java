package leetcode.algorithms;

/**
 * @author windeaker
 * @description 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * @Date 2021/9/16
 */
public class Q83 {


    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode point = head;
        ListNode pre = head;
        while(point!=null){
            if (pre==point){
                point=point.next;
                continue;
            }else{
                if (pre.val>=point.val){
                    pre.next=point.next;
                    point.next=null;
                    point=pre.next;
                }else{
                    point=point.next;
                    pre=pre.next;
                }
            }
        }
        return head;
    }


}
