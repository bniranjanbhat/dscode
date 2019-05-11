package com.code.linkedlist;

public class ReverseAList {
	/** * Java Program to reverse a singly list without using recursion. */
		public static void main(String[] args) {
			// creating a singly linked// list
			SinglyLinkedList.Node head = new SinglyLinkedList.Node(1);
			SinglyLinkedList linkedlist = new SinglyLinkedList(head);
			// // adding node into singly linked list
			linkedlist.add(new SinglyLinkedList.Node(2));
			linkedlist.add(new SinglyLinkedList.Node(3));
			// printing a singly linked list
			linkedlist.print();
			// reversing the singly linked list
			linkedlist.reverse();
			// printing the singly linked list again
			linkedlist.print();
		}
	}

	// /** * A class to represent singly list in Java * * @author WINDOWS 8 * */
	class SinglyLinkedList {
		static class Node {
			private int data;
			private Node next;

			public Node(int data) {

				this.data = data;
			}

			public int data() {
				return data;
			}

			public Node next() {
				return next;
			}
		}

		private Node head;

		public SinglyLinkedList(Node head) {
			this.head = head;
		}

		/** * Java method to add an element to linked list * @param node */
		public void add(Node node) {
			Node current = head;
			while (current != null) {
				if (current.next == null) {
					current.next = node;
					break;
				}
				current = current.next;
			}
		}

		/** * Java method to print a singly linked list */
		public void print() {
			Node node = head;
			while (node != null) {
				System.out.print(node.data() + " ");
				node = node.next();
			}
			System.out.println("");
		}

		/** * Java method to reverse a linked list without recursion */
		/*
		 * 1. we will keep three references of type node: pointer, previous and current.
		 * 2. we start with pointer as head, previous as null and current as null.
		 * 3. Until pointer is not null, we will do the following steps: (Until we reach the end of the list)
		 * 4. We assign pointer to current ( we are storing the current node in a reference variable called current)
		 * 5. pointer becomes pointer.next ( we will store the next node in the pointer variable)
		 * 6. current.next becomes previous ( we will set the current node's next reference to 
		 * 												previous node , which is stored in the previous variable 
		 * 												and will have null value to start with. Since the last node's next reference in a linkedlist is null)
		 * 7. set previous as current ( we will set the value of current node into previous node, since in the next iteration we will be updating the current node)
		 * 8. update head to point to current ( since we are iterating through the list, we will keep updating head as the current node in each iteration so that 
		 * when we reach the end of the list, head is already set to the last node of the list , which will be the first node of the reversed list)
		 */
				
		public void reverse() {
			Node pointer = head;
			Node previous = null, current = null;
			while (pointer != null) {
				current = pointer;
				pointer = pointer.next;
				// reverse the link
				current.next = previous;
				previous = current;
				head = current;
			}
		}
	}
