package leetcode.algorithms;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        // todo 晕了晕了等下弄
        ListNode point = head, preHead = null;
        while (k > 0) {
            //如果到底了，就头尾连接
            if (point.next==null){
                point.next=head;
            }
            if (preHead == null) {
                preHead = point;
            } else {
                preHead = preHead.next;
            }
            point = point.next;
            k--;
        }
        //首尾相连
        point.next = head;
        //创建新头节点
        head = preHead.next;
        preHead.next = null;
        return head;
    }
}
