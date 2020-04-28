package leetcode.algorithms;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 插队法 - 遍历迭代 o(n)
 */
public class Q21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        //p1为比较值，p2为被比较值
        ListNode p1=l1,p2=l2,tail=new ListNode(Integer.MIN_VALUE),temp=null;

        while(p1!=null){
            while(p1.val>=p2.val){
                tail.next=p2;
                p2=p2.next;
                tail=tail.next;
            }
            temp=p2;
            p2=p1;
            p1=temp;
        }
        return tail.next;
    }

    public ListNode otherSample(ListNode l1, ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = l1;
        ListNode pre = head;
        while (l2 != null) {
            ListNode t1 = pre.next;
            ListNode t2 = l2.next;
            while (l2.val > t1.val) {
                if (t1.next == null) {
                    t1.next = l2;
                    return head.next;
                } else {
                    pre = pre.next;
                    t1 = t1.next;
                }
            }
            pre.next = l2;
            l2.next = t1;
            l2 = t2;
        }
        return head.next;
    }

    public ListNode wrongSolution(ListNode l1, ListNode l2){
        if (l1==null){
            return l2;
        }
        if (l2==null){
            return l1;
        }
        ListNode head=null,p1=l1,p2=l2,tmpTail=null;
        while(p1!=null||p2!=null){
            if (p1!=null&&p2!=null){
                if (p1.val<=p2.val){
                    if (head==null){
                        head=p1;
                        p1=p1.next;
                        head.next=p2;
                        tmpTail=p2;
                        p2=p2.next;
                    }else{
                        tmpTail.next=p1;
                        p1=p1.next;
                        tmpTail.next.next=p2;
                        tmpTail=p2;
                        p2=p2.next;
                    }
                }else{
                    if (head==null){
                        head=p2;
                        p2=p2.next;
                        head.next=p1;
                        tmpTail=p1;
                        p1=p1.next;
                    }else{
                        tmpTail.next=p2;
                        p2=p2.next;
                        tmpTail.next.next=p1;
                        tmpTail=p1;
                        p1=p1.next;
                    }
                }
            }else if (p1!=null&&p2==null){
                if (head==null){
                    head=p1;
                    p1=p1.next;
                    head.next=p2;
                    tmpTail=null;
                }else{
                    tmpTail.next=p1;
                    p1=p1.next;
                    tmpTail=tmpTail.next;
                    tmpTail.next=p2;
                }
            }else{
                if (head==null){
                    head=p2;
                    p2=p2.next;
                    head.next=p1;
                    tmpTail=null;
                }else{
                    tmpTail.next=p2;
                    p2=p2.next;
                    tmpTail=tmpTail.next;
                    tmpTail.next=p1;
                }
            }

        }
        return head;
    }
}
