package com.algorithmspractice.LinkedList;

import com.algorithmspractice.utils.HelperUtils;

//Sort a linked list in O(n log n) time using constant space complexity.
public class SortLinkedList {
    public static void main(String[] args) {
        ListNode root = HelperUtils.createLinkedListFromArray(new int[]{5, 4, 3, 2, 1});
        root = sortList(root);
        HelperUtils.printLinkedList(root);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(slow != null && fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;


        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0), iter = dummy, next;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                iter.next = l1;
                l1 = l1.next;
            }else{
                iter.next = l2;
                l2 = l2.next;
            }

            iter = iter.next;
        }

        if(l1 != null){
            iter.next = l1;
        }

        if(l2 != null){
            iter.next = l2;
        }

        return dummy.next;
    }

}
