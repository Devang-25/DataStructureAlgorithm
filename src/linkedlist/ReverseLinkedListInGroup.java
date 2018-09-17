package linkedlist;

public class ReverseLinkedListInGroup {

	public static void main(String[] args) {

		Node head = getPopulatedLL();
		printLinkedList(head);
		Node reversedLinkedList = reverseInGroup(head, 3);
		printLinkedList(reversedLinkedList);
	}

	private static Node reverseInGroup(Node head, int k) {

		Node current = head;
		Node next = null;
		Node prev = null;
		
		int count = 0;
		while (count < k && current != null) {
			next = current.point;
			current.point = prev;
			prev = current;
			current = next;
			count++;
		}
		if (next != null) {
			head.point = reverseInGroup(next, k);
		}
		return prev;
	}

	private static Node getPopulatedLL() {
		Node head = new Node(10);
		Node first = new Node(11);
		Node second = new Node(12);
		Node third = new Node(13);
		Node four = new Node(14);

		head.point = first;
		first.point = second;
		second.point = third;
		third.point = four;
		four.point = null;
		return head;
	}

	public static void printLinkedList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.getData() + "-> ");
			temp = temp.getPoint();
		}
		System.out.println("null");
	}
}
