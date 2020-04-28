package leetcode.algorithms;

import java.util.HashMap;

public class Q138 {
    public Node copyRandomList(Node head) {
        Node pre=null,point=head,nHead=null,nPre=null,nPoint;
        HashMap<Node,Node> linkTemp=new HashMap<>();
        while(point!=null){
            nPoint=new Node(point.val);
            nPoint.random=point.random;
        }
        return null;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}


