package com.elements;

public class ListUtil {
    public static ListNode createLinkedList(int[] arr) {
        ListNode linkedList = null;
        for(int i = arr.length-1 ; i>=0 ; i--) {
            ListNode node = new ListNode();
            node.val = arr[i];
            node.next=linkedList;
            linkedList=node;
        }
        return linkedList;
    }

    public static void printLinkedList(ListNode head) {
        while(head!=null) {
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println("End ");
    }

}
