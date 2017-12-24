package com.algorithmspractice.LinkedList;

//You are given two non-empty linked lists representing two non-negative integers.
// The digits are stored in reverse order and each of their nodes contain a single digit.
// Add the two numbers and return it as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//        Output: 7 -> 0 -> 8
//        Explanation: 342 + 465 = 807.

//Time complexity : O(max(m,n)).
// Assume that m and n represents the length of l1 and l2 respectively,
// the algorithm above iterates at most max(m, n) times.

//Space complexity : O(max(m,n)).
// The length of the new list is at most max(m,n)+1.

public class AddTwoNumbers {
    public static void main(String args[]){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        print(addTwoNumbers(l1, l2));

        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(9);

        ListNode l4 = new ListNode(1);

        print(addTwoNumbers(l3, l4));
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), result = dummy;
        int carry = 0, sum = 0;

        while(l1 != null || l2 != null) {
            int p = l1 != null ? l1.val : 0;
            int q = l2 != null ? l2.val : 0;
            sum = p + q + carry;
            carry = sum / 10;
            ListNode next = new ListNode(sum % 10);
            result.next = next;
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            result = next;
        }

        //last carry if remaining
        if(carry > 0){
            result.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public static void print(ListNode head){
        while(head != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

}