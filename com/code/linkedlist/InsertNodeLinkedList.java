/**
 * 
 */
package com.code.linkedlist;

/**
 * @author bniranjanbhat
 * You’re given the pointer to the head node of a linked list, an integer to add to the list and the position at which the integer 
 * must be inserted. Create a new node with the given integer, insert this node at the desired position and return the head node.
 * A position of 0 indicates head, a position of 1 indicates one node away from the head and so on. 
 * The head pointer given may be null meaning that the initial list is empty.
 */
public class InsertNodeLinkedList {
    Node InsertNth(Node head, int data, int position) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (head == null) {
            return newNode;
        }
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node prev = null;
        Node current = head;
        int i = 0;
        while (current !=null && i < position) {
            prev = current;
            current = current.next;
            i++;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
    }
    
    class Node{

        public Node next;
        public int data;
        
    }
}
