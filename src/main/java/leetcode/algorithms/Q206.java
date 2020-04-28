package leetcode.algorithms;

/**
 * 206. 反转链表
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Q206 {
    public ListNode reverseList(ListNode head) {
        java.util.Stack<ListNode> temp=new java.util.Stack<>();
        ListNode point=head,nHead=null,pre=null;
        while(point!=null){
            temp.push(point);
            point=point.next;
        }
        ListNode tempNode=null;
        while(!temp.empty()){
            tempNode=temp.pop();
            if (nHead==null){
                pre=nHead=tempNode;
            }else {
                pre.next = tempNode;
                pre=pre.next;
            }
            pre.next=null;
        }
        return nHead;
    }
}
