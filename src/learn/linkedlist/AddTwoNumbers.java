package learn.linkedlist;

import com.elements.ListNode;
import com.elements.ListUtil;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode list1 = ListUtil.createLinkedList(new int[]{2,4,3});
        ListNode list2 = ListUtil.createLinkedList(new int[]{5,6,4});
        ListUtil.printLinkedList(list1);
        ListUtil.printLinkedList(list2);
        ListNode outList = addTwoNumbers(list1, list2);
        ListUtil.printLinkedList(outList);
    }

    //https://leetcode.com/problems/add-two-numbers/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode list = null;
        int num1 = 0;
        int num2 = 0;
        int remainder = 0;

        while(l1 != null || l2 != null || remainder != 0) {

            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            } else {
                num1 = 0;
            }

            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            } else {
                num2 = 0;
            }

            int sum = num1+num2+remainder;
            int toAdd = sum%10;
            remainder = sum/10;

            ListNode node = new ListNode();
            node.val = toAdd;
            if(head == null) {
                head = node;
                list = node;
            } else {
                list.next = node;
                list = list.next;
            }
        }
        return head;
    }
}
