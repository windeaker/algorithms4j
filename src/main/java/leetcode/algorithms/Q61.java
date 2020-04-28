package leetcode.algorithms;

public class Q61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode point=head;
        ListNode pre=null;
        int i=0;
        while(i==k){
            //組成一個鏈表環
            if (point==null){
                pre.next=head;
                point=head;
                //到达终点，可以开始计数了。
                i++;
            }
            //
            if (pre==null){
                pre=point;
            }
            point=point.next;
            if (i>0){

            }
        }
        return head;
    }
}
