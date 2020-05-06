package leetcode.algorithms;

import java.util.*;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 解法有二，一是分治
 */
public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0){
            return null;
        }
        Queue<ListNode> queue=new ArrayDeque<>();
        for(ListNode temp:lists){
            if (temp!=null){
                queue.add(temp);
            }
        }
        if (queue.isEmpty()){
            return null;
        }
        while(queue.size()>1){
            ListNode l1= queue.poll();
            ListNode l2= queue.poll();
            queue.add(mergeTwoLists(l1,l2));
        }
        return queue.poll();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    //todo 待研究用优先队列合并K个链表
    public ListNode mergeKListsWithPriorityQueue(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode[] listNodes=new ListNode[3];
        ListNode a=new ListNode(1);
        listNodes[0]=a;
        a.next=new ListNode(4);
        a.next.next=new ListNode(5);
        a=new ListNode(1);
        listNodes[1]=a;
        a.next=new ListNode(3);
        a.next.next=new ListNode(4);
        a=new ListNode(2);
        listNodes[2]=a;
        a.next=new ListNode(6);
        new Q23().mergeKLists(listNodes);
    }
}
