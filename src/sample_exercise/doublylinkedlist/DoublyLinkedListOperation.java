package sample_exercise.doublylinkedlist;

import java.util.NoSuchElementException;

/**
 * Created by rakeshgupta on 9/24/16.
 */
public class DoublyLinkedListOperation<E> {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedListOperation() {
        this.size = 0;
    }

    private class Node{
        E element;
        Node next;
        Node pre;
        public Node(E element, Node next, Node pre){
            this.element = element;
            this.next = next;
            this.pre = pre;
        }
    }

    public int size(){
        return  size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E element){
        Node temp = new Node(element, head, null);
        if (tail !=null)
            tail.next = temp;
        if (head ==null)
            head = temp;
        size++;
        System.out.println("adding: " + element);
    }

    public void iterateForward(){
        System.out.println("iterating forword ..");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    public void iterateBackword(){
        System.out.println("iterating Backword ..");
        Node temp = tail;
        while (temp != null){
            System.out.println(temp.element);
            temp = temp.pre;
        }

    }

    public E removeFirst(){
        if (size ==0)
            throw new NoSuchElementException();
        Node temp = head;
        head = head.next;
        head.pre = null;
        size--;
        System.out.println("deleted: " + temp.element);
        return  temp.element;
    }

    public E removeLast(){
        if (size ==0 )
            throw new NoSuchElementException();
        Node temp = tail;
        tail = tail.pre;
        tail.pre = null;size--;
        System.out.println("deleted: " + temp.element);
        return temp.element;
    }

    public static void main(String[] args) {
        DoublyLinkedListOperation<Integer> dll = new DoublyLinkedListOperation<>();
        dll.addFirst(10);
        dll.addFirst(30);
        dll.addFirst(343);
        dll.addFirst(298289);
        dll.iterateForward();
        dll.iterateBackword();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateForward();
    }

}
