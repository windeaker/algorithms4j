package aim_offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author windeaker
 *
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class A3_GetArrayListFromLinkListWithDESC {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        ListNode next=listNode;
        while(next!=null){
            stack.push(next.val);
            next=next.next;
        }
        ArrayList<Integer> result=new ArrayList<>(stack.size());
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }


}
