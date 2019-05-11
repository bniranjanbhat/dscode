package com.code.linkedlist;

/*
 * Basic example of how a LinkedList looks like and how insertion can be done.
 * 
 */
public class SinglyLinkedList1 {
	Node head;  // head of list 
	  
    /* Node Class */
	
    class Node 
    { 
    	
        int data; 
        Node next; //reference to the next node.
        // Constructor to create a new node 
        Node(int d) {
        	data = d; 
        	next = null; } 
    } 
    
    /*
     * Add a node to the head of the list
     */
	public void push(int new_data) 
	{ 
	    /* 1 & 2: Allocate the Node & 
	              Put in the data*/
	    Node new_node = new Node(new_data); 
	  
	    /* 3. Make next of new Node as head */
	    new_node.next = head; 
	  
	    /* 4. Move the head to point to new Node */
	    head = new_node; 
	} 
	
	public void insertAfter(Node prev_node, int new_data) 
	{ 
	    /* 1. Check if the given Node is null */
	    if (prev_node == null) 
	    { 
	        System.out.println("The given previous node cannot be null"); 
	        return; 
	    } 
	  
	    /* 2. Allocate the Node & 
	       3. Put in the data*/
	    Node new_node = new Node(new_data); 
	  
	    /* 4. Make next of new Node as next of prev_node */
	    new_node.next = prev_node.next; 
	  
	    /* 5. make next of prev_node as new_node */
	    prev_node.next = new_node; 
	} 
	
	
	/*
	 * Insert a node to the end of the list
	 */
	public void append(int new_data) 
	{ 
	    
	    /* 4. If the Linked List is empty, then make the 
	           new node as head */
	    if (head == null) 
	    { 
	        head = new Node(new_data); 
	        return; 
	    } 
	    /* 1. Allocate the Node & 
	       2. Put in the data 
	       3. Set next as null */
	    Node new_node = new Node(new_data); 
	  
	  
	    /* 4. This new node is going to be the last node, so 
	         make next of it as null */
	    new_node.next = null; 
	  
	    /* 5. Else traverse till the last node */
	    Node last = head;  
	    while (last.next != null) 
	        last = last.next; 
	  
	    /* 6. Change the next of last node */
	    last.next = new_node; 
	    return; 
	} 
	
	
	 /* Given a key, deletes the first occurrence of key in linked list */
    void deleteNode(int key) 
    { 
        // Store head node 
        Node temp = head, prev = null; 
  
        // If head node itself holds the key to be deleted 
        if (temp != null && temp.data == key) 
        { 
            head = temp.next; // Changed head 
            return; 
        } 
  
        // Search for the key to be deleted, keep track of the 
        // previous node as we need to change temp.next 
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
  
        // If key was not present in linked list 
        if (temp == null) return; 
  
        // Unlink the node from linked list 
        prev.next = temp.next; 
    } 
    
    /* Given a reference  to the head of a list 
    and a position, deletes the node at the given position */
    void deleteNodeAtPosition(int position) 
    { 
        // If linked list is empty 
        if (head == null) 
            return; 
  
        // Store head node 
        Node temp = head; 
  
        // If head needs to be removed 
        if (position == 0) 
        { 
            head = temp.next;   // Change head 
            return; 
        } 
  
        // Find previous node of the node to be deleted 
        for (int i=0; temp!=null && i<position-1; i++) 
            temp = temp.next; 
  
        // If position is more than number of ndoes 
        if (temp == null || temp.next == null) 
            return; 
  
        // Node temp->next is the node to be deleted 
        // Store pointer to the next of node to be deleted 
        Node next = temp.next.next; 
  
        temp.next = next;  // Unlink the deleted node from list 
    } 
    
   // lenght of the linkedlist 
    public int getCount() 
    { 
        Node temp = head; 
        int count = 0; 
        while (temp != null) 
        { 
            count++; 
            temp = temp.next; 
        } 
        return count; 
    } 
    
    public boolean search( int x) 
    { 
        Node current = head;    //Initialize current 
        while (current != null) 
        { 
            if (current.data == x) 
                return true;    //data found 
            current = current.next; 
        } 
        return false;    //data not found 
    } 
  
	
}
