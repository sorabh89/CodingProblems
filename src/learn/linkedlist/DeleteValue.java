package learn.linkedlist;

import com.elements.ListNode;
import com.elements.ListUtil;

public class DeleteValue {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1};
        ListNode list = ListUtil.createLinkedList(arr);
        ListUtil.printLinkedList(list);
        list = removeElements(list, 2);
        ListUtil.printLinkedList(list);
    }

    //https://leetcode.com/problems/remove-linked-list-elements/
    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = null;

        while(node !=  null) {
            if(node.val == val) {
                if(node == head) {
                    head = node.next;
                } else {
                    prev.next = node.next;
                }
            } else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }

}
