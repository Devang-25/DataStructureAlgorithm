package doublylinkedlist;

import sun.awt.AWTIcon32_security_icon_yellow16_png;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Created by rakeshgupta on 9/23/16.
 */
public class DoublyLinkedList<Item> implements Iterator<Item> {

    private int num;
    private Node pre;
    private Node post;

    public  DoublyLinkedList(){
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public boolean isEmpty(){
        return num==0;
    }

    public int size(){
        return num;
    }

    public void add(Item item){
        Node last = post.prev;
        Node x  = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        num++;
    }

    public ListIterator<Item> iterator(){
        return  new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements ListIterator<Item> {

        private Node current = pre.next;
        private Node lastAccessed = null;

        private int index = 0;



        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            if(!hasNext())
                throw new NoSuchElementException();

            lastAccessed = current;
            Item item = current.item;
            current = current.next;
            index++;
            return item;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Item previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            current = current.prev;
            index--;
            lastAccessed = current;
            return current.item;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            if(lastAccessed == null)
                throw new IllegalStateException();
            Node x = lastAccessed.prev;
            Node y = lastAccessed.next;
            x.next = y;
            y.prev = x;
            num--;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }

        @Override
        public void set(Item item) {
            if (lastAccessed == null)
                throw new IllegalStateException();
            lastAccessed.item = item;
        }

        @Override
        public void add(Item item) {
            Node x = current.prev;
            Node y = new Node();
            Node z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            num++;
            index++;
            lastAccessed = null;
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
//        for (Item item: ){
//            s.append(item + " ");
//            return s.toString();
//        }
        return s.toString();
    }



    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }


    public static void main(String args[]){
        int num =  5;//Integer.parseInt(args[0]);
        System.out.println("Enter integers between 1 to 99");
        DoublyLinkedList<Integer> integerDoublyLinkedList =
                new DoublyLinkedList<Integer>();

        for (int i = 0; i < num; i++) {
            integerDoublyLinkedList.add((100*1));
        }
        System.out.println(integerDoublyLinkedList);
        System.out.println();

        ListIterator<Integer> iterator = integerDoublyLinkedList.iterator();

        System.out.println("Add 1 to each element via next() and set()");
        while (iterator.hasNext()){
            int x = iterator.next();
            iterator.set(x+1);
            System.out.print(x);
        }
        System.out.println(integerDoublyLinkedList);
        System.out.println();

        System.out.println("Multiply each element by 3 via previous() and set()");
        while (iterator.hasPrevious()){
            int x = iterator.previous();
            iterator.set(x*3);
        }

        System.out.println("Remove elements that are multiple of" +
                " 4 via next() and remove()");
        while (iterator.hasNext()){
            int x = iterator.next();
            if (x % 4 == 0)
                iterator.remove();
        }
        System.out.println("Remove element via next() and remove() that are even");
        while (iterator.hasPrevious()){
            int x = iterator.previous();
            if (x % 2 == 0)
                iterator.remove();
        }

        System.out.println("Add elements via next() and add()");
        while (iterator.hasNext()){
            int x = iterator.next();
            iterator.add(x+1);
        }
        System.out.println(integerDoublyLinkedList);
        System.out.println();

        System.out.println("Add elements via previous() and add()");
        while (iterator.hasPrevious()){
            int x = iterator.previous();
            iterator.add(x*10);
            iterator.previous();
        }

        System.out.println(integerDoublyLinkedList);
        System.out.println();
    }


}
