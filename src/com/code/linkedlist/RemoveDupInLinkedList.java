package com.code.linkedlist;

import java.util.Hashtable;

public class RemoveDupInLinkedList {
	LinkedListNode head;

	public static void main(String args[]){
		RemoveDupInLinkedList list = new RemoveDupInLinkedList();
	    list.addNode(1);
	    list.addNode(1);
	    list.addNode(1);
	    list.addNode(2);
	    list.addNode(3);
	    list.addNode(2);

	    list.print();
	    list.deleteDupsNoStorage(list.head);
	    System.out.println();
	    list.print();
	}

	public void print(){
	    LinkedListNode n = head;
	    while(n!=null){
	        System.out.print(n.data +" ");
	        n = n.next;
	    }
	}

	public void deleteDups(LinkedListNode n){
	    Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
	    LinkedListNode prev = null;

	    while(n !=null){
	        if(table.containsKey(new Integer(n.data))){
	            prev.next = n.next;     //skip the previously stored references next node
	        }else{
	            table.put(new Integer(n.data) , true);
	            prev = n;       //stores a reference to n
	        }

	        n = n.next;
	    }
	}

	public void deleteDupsNoStorage(LinkedListNode n){
	    LinkedListNode current = n;

	    while(current!=null){
	        LinkedListNode runner = current;
	        while(runner.next!=null){
	            if(runner.next.data == current.data){
	                runner.next = runner.next.next;
	            }else{
	                runner = runner.next;
	            }
	        }
	        current = current.next;
	    }

	}

	public void addNode(int d){
	    LinkedListNode n = new LinkedListNode(d);
	    if(this.head==null){
	        this.head = n;
	    }else{
	        n.next = head;
	        head = n;
	    }
	}

	private class LinkedListNode{
	    LinkedListNode next;
	    int data;

	    public LinkedListNode(int d){
	        this.data = d;
	    }
	}
}
