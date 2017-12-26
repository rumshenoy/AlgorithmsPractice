package com.algorithmspractice.utils;

import com.algorithmspractice.LinkedList.ListNode;

public class HelperUtils {
    public static void printArray(int[] anArray) {
        for (int i = 0; i < anArray.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(anArray[i]);
        }
        System.out.println();
    }

    public static void printLinkedList(ListNode head) {
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public static ListNode createLinkedListFromArray(int[] ints) {
        ListNode dummy = new ListNode(0), iter = dummy;
        for(int i =0; i < ints.length; i++){
            iter.next = new ListNode(ints[i]);
            iter = iter.next;
        }
        return dummy.next;
    }
}
