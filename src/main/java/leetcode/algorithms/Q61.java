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
        ListNode point = head, preHead = null;
        int size=0;
        while(point!=null){
            preHead=point;
            point=point.next;
            size++;
        }
        if (size==0){
            return head;
        }
        //这时候，preHead已指向最后一个节点，首尾相连
        preHead.next=head;
        //精简旋转圈数
        int tmp=k%size;
        //下一个尾节点的位置
        tmp=size-tmp;
        while(tmp>0){
            preHead=preHead.next;
            tmp--;
        }
        head=preHead.next;
        preHead.next=null;
        return head;
    }
}
