package com.algorithmspractice.LinkedList;
//A linked list is given such that each node contains an additional random pointer
// which could point to any node in the list or null.
// Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class CopyListWithRandomPointer {
    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(5);
        RandomListNode n1 = new RandomListNode(3);
        RandomListNode n2 = new RandomListNode(6);
        RandomListNode n3 = new RandomListNode(2);
        RandomListNode n4 = new RandomListNode(7);

        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n3;
        n2.random = n4;
        n4.random = n1;

        RandomListNode copy = copyRandomList(root);

        printRandomListNode(root);
        printRandomListNode(copy);
    }

    private static void printRandomListNode(RandomListNode head) {
        while(head != null){
            int label = -1;
            if(head.random != null){
                label = head.random.label;
            }
            System.out.print(head.label + " (random: " + label +") ->" );
            head = head.next;
        }
        System.out.println();
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0), iter = dummy, cur = head, next;

        //A -> A` -> B -> B`->...
        while(cur != null){
            RandomListNode node = new RandomListNode(cur.label);
            next = cur.next;
            cur.next = node;
            node.next = next;
            cur = next;
        }

        cur = head;
        //copy random pointers;
        while(cur != null && cur.next != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        while(cur != null){
            iter.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            iter = iter.next;
        }

        return dummy.next;
    }
}