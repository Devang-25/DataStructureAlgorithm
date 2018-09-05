package linkedlist.circularlinkedlist;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    public CircularSinglyLinkedList(){
        this.last = null;
        this.length = 0;
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void addNode(ListNode listNode){
        if(this.last == null) {
            last = listNode;
            return;
        }
        this.last.next = listNode;
        listNode.next = last;
        this.last = listNode;
        length++;
    }

    public void createSampleLinkedList(){
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(10);

        first.next = second;
        second.next = third;
        third.next = fourth;
        this.last = fourth;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createSampleLinkedList();
        csll.display();

        System.out.println(csll.getLength());

    }

    private  void display() {
        if(last == null)
            return;
        ListNode first = last.next;
        while(first != last){
            System.out.println(first.data + " ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

}
