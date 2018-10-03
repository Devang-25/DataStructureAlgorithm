package linkedlist.circularlinkedlist;

public class SplitCircularLinkedList {

	private Node head;
	private static Node head1, head2;

	private static class Node {
		int data;
		Node next, prev;

		Node(int d) {
			data = d;
			next = prev = null;
		}
	}

	public static void main(String[] args) {
		SplitCircularLinkedList list = new SplitCircularLinkedList();
		
		// Created linked list will be 12->56->2->11
		list.head = new Node(12);
		list.head.next = new Node(56);
		list.head.next.next = new Node(2);
		list.head.next.next.next = new Node(11);
		list.head.next.next.next.next = new Node(55);
		list.head.next.next.next.next.next = new Node(17);
		list.head.next.next.next.next.next.next = list.head;

		System.out.println("Original Circular Linked list ");
		list.printList(list.head);

		// Split the list
		list.splitList();
		System.out.println("");
		System.out.println("First Circular List ");
		list.printList(head1);
		System.out.println("");
		System.out.println("Second Circular List ");
		list.printList(head2);

	}

	private void splitList() {
		Node slowPtr = head;
		Node fastPtr = head;

		if (head == null)
			return;

		while (fastPtr.next != head && fastPtr.next.next != head) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}

		if (fastPtr.next.next == head) {
			fastPtr = fastPtr.next;
		}

		head1 = head;

		if (head.next != head) {
			head2 = slowPtr.next;
		}
		fastPtr.next = slowPtr.next;
		slowPtr.next = head;
	}

	/**
	 * Function to print nodes in a given singly linked list.
	 * 
	 */
	void printList(Node node) {
		Node temp = node;
		if (node != null) {
			do {
				System.out.print(temp.data + " ");
				temp = temp.next;
			} while (temp != node);
		}
	}
}
